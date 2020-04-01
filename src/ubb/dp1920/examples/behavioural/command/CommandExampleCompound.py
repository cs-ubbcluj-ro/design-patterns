from controller.CarController import CarController
from controller.ClientController import ClientController
from controller.RentalController import RentalController
from controller.UndoController import UndoController
from datetime import date
from util import printReposWithMessage
from repository.Repository import Repository

"""
Main module for for Command design pattern example
"""
def undoExampleHardest():
    undoController = UndoController()
    clientRepo = Repository()
    carRepo = Repository()

    '''
    Start rental Controller
    '''
    rentRepo = Repository()
    rentController = RentalController(undoController, rentRepo, carRepo, clientRepo)
    
    '''
    Start client Controller
    '''
    clientController = ClientController(undoController, rentController,  clientRepo)
    
    '''
    Start car Controller
    '''
    carController = CarController(undoController, rentController,carRepo)

    '''
    We add 1 client, 1 car and 2 rentals
    '''
    clientSophia = clientController.create(103, "2990511035588", "Sophia")
    carHyundaiTucson = carController.create(201, "CJ 02 TWD", "Hyundai", "Tucson")
    rentController.createRental(301, clientSophia, carHyundaiTucson, date(2016, 11, 1), date(2016, 11, 30))
    rentController.createRental(302, clientSophia, carHyundaiTucson, date(2016, 12, 1), date(2016, 12, 31))
    
    printReposWithMessage("We added Sophia, the Hyundai and its 2 rentals", clientRepo, carRepo, rentRepo)

    carController.delete(201)
    printReposWithMessage("Delete the Hyundai (also deletes its rentals)", clientRepo, carRepo, rentRepo)
    
    '''
    Now undo the performed operations, one by one
    '''
    undoController.undo()
    printReposWithMessage("1 undo, the Hyundai and its rentals are back", clientRepo, carRepo, rentRepo)

    undoController.undo()
    printReposWithMessage("1 undo deletes the second rental", clientRepo, carRepo, rentRepo)
     
    undoController.undo()
    printReposWithMessage("1 undo deletes the first rental", clientRepo, carRepo, rentRepo)
 
    undoController.undo()
    printReposWithMessage("1 undo deletes the Hyundai", clientRepo, carRepo, rentRepo)

    '''
    After 5 undos, all repos should be empty, as we did 5 operations in total
    '''
    undoController.undo()
    printReposWithMessage("1 undo deletes Sophia (no more undos)", clientRepo, carRepo, rentRepo)

    '''
    Redos start here
    '''
    undoController.redo()
    printReposWithMessage("1 redo and Sophia is added", clientRepo, carRepo, rentRepo)

    undoController.redo()
    printReposWithMessage("1 redo adds the Hyundai", clientRepo, carRepo, rentRepo)

    undoController.redo()
    printReposWithMessage("1 redo adds the first rental", clientRepo, carRepo, rentRepo)

    undoController.redo()
    printReposWithMessage("1 redo adds the second rental", clientRepo, carRepo, rentRepo)

    undoController.redo()
    printReposWithMessage("1 redo deletes the Hyundai and its rentals (again)", clientRepo, carRepo, rentRepo)

    '''
    Let's do a few undos again...
    '''
    undoController.undo()
    undoController.undo()
    undoController.undo()

    printReposWithMessage("3 undos later, we have Sophia and the Hyundai", clientRepo, carRepo, rentRepo)

    '''
    Now we try something new - let's add another car!
    
    NB!
        A new operation must invalidate the history for redo() operations
    '''
    carController.create(202, "CJ 02 SSE", "Dacia", "Sandero")
    print("\n Do we have a redo? -", undoController.redo(), "\n")
    
    '''
    Now we should have 2 cars
    '''
    printReposWithMessage("After adding the Dacia, there is no redo ", clientRepo, carRepo, rentRepo)
    
    '''
    However, undos is still available !
    '''
    undoController.undo()
    printReposWithMessage("1 undo deletes the Dacia", clientRepo, carRepo, rentRepo)
    
    undoController.undo()
    printReposWithMessage("1 undo deletes the Hyundai", clientRepo, carRepo, rentRepo)

undoExampleHardest()
