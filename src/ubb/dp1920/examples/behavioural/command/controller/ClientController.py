from controller.UndoController import FunctionCall, Operation, CascadedOperation
from domain.Client import Client


class ClientController:
    def __init__(self, undoController, rentalController, repository):
        self.__repository = repository
        self._rentalController = rentalController
        self._undoController = undoController

    def create(self, clientId, clientCNP, clientName):
        client = Client(clientId, clientCNP, clientName)
        self.__repository.store(client)

        '''
        If the operation did not raise an Exception, then we record it for Undo/Redo
        '''
        redo = FunctionCall(self.create, clientId, clientCNP, clientName)
        undo = FunctionCall(self.delete, clientId)
        cascadeOp = CascadedOperation(Operation(redo, undo))
        self._undoController.recordOperation(cascadeOp)

        return client

    def delete(self, clientId):
        '''
            1. Delete the client
        '''
        client = self.__repository.delete(clientId)

        '''
            2. Delete their rentals
            NB! This implementation is not transactional, i.e. the two delete operations are performed separately
        '''
        rentals = self._rentalController.filterRentals(client, None)
        for rent in rentals:
            self._rentalController.deleteRental(rent.getId(), False)

        '''
        If the operation did not raise an Exception, then we record it for Undo/Redo
        '''
        cascadeOp = CascadedOperation()

        redo = FunctionCall(self.delete, clientId)
        undo = FunctionCall(self.create, client.id, client.cnp, client.name)
        cascadeOp.add(Operation(redo, undo))

        for rent in rentals:
            redo = FunctionCall(
                self._rentalController.deleteRentalNoUndo, rent.id)
            undo = FunctionCall(self._rentalController.createRental,
                                rent.id, rent.client, rent.car, rent.start, rent.end)
            cascadeOp.add(Operation(redo, undo))
        self._undoController.recordOperation(cascadeOp)

        return client

    def getClientCount(self):
        return len(self.__repository)

    def update(self, car):
        '''
            NB! Undo/redo is also needed here
        '''
        pass
