from controller.UndoController import FunctionCall, Operation,CascadedOperation
from domain.Car import Car


class CarController:
    def __init__(self, undoController, rentalController,  repository):
        self.__repository = repository
        self._rentalController = rentalController
        self._undoController = undoController

    def create(self, carId, licensePlate, carMake, carModel):
        car = Car(carId, licensePlate, carMake, carModel)
        self.__repository.store(car)

        '''
        If the operation did not raise an Exception, then we record it for Undo/Redo
        '''
        redo = FunctionCall(self.create, carId,
                            licensePlate, carMake, carModel)
        undo = FunctionCall(self.delete, carId)
        cascadeOp = CascadedOperation(Operation(redo, undo))
        self._undoController.recordOperation(cascadeOp)
        return car

    def delete(self, carId):
        '''
            1. Delete the car from the repository
        '''
        car = self.__repository.delete(carId)

        '''
            2. Delete its rentals
            NB! This implementation is not transactional, i.e. the two delete operations are performed separately
        '''
        rentals = self._rentalController.filterRentals(None, car)
        for rent in rentals:
            self._rentalController.deleteRental(rent.id, False)

        '''
        If the operation did not raise an Exception, then we record it for Undo/Redo
        '''
        cascadeOp = CascadedOperation()

        redo = FunctionCall(self.delete, carId)
        undo = FunctionCall(self.create, car.id,
                            car.license, car.make, car.model)
        cascadeOp.add(Operation(redo, undo))

        for rent in rentals:
            redo = FunctionCall(self._rentalController.deleteRental, rent.id)
            undo = FunctionCall(self._rentalController.createRental,
                                rent.id, rent.client, rent.car, rent.start, rent.end)
            cascadeOp.add(Operation(redo, undo))
        self._undoController.recordOperation(cascadeOp)

        return car

    def update(self, car):
        '''
            NB! Undo/redo is also needed here
        '''
        pass
