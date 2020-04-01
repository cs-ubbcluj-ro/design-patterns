'''
Command design pattern that does not actually use compound commands

@author: Arthur
'''
from controller.UndoController import UndoController
from controller.RentalController import RentalController
from controller.ClientController import ClientController
from controller.CarController import CarController
from datetime import date
from util import printReposWithMessage
from repository.Repository import Repository

"""
Main module for for Command design pattern example
"""


def undoExampleMedium():
    undoController = UndoController()
    clientRepo = Repository()
    carRepo = Repository()

    '''
    Start rental Controller
    '''
    rentRepo = Repository()
    rentController = RentalController(
        undoController, rentRepo, carRepo, clientRepo)

    '''
    Start client Controller
    '''
    clientController = ClientController(
        undoController, rentController, clientRepo)

    '''
    We add 3 clients
    '''
    clientController.create(103, "2990511035588", "Sophia")
    clientController.create(104, "2670511035588", "Carol")
    clientController.create(105, "2590411035588", "Bob")
    printReposWithMessage("We added 3 clients", clientRepo, None, None)

    '''
    We delete 2 of the clients
    '''
    clientController.delete(103)
    clientController.delete(105)
    printReposWithMessage("Deleted Sophia and Bob", clientRepo, None, None)

    '''
    We undo twice
    '''
    undoController.undo()
    printReposWithMessage("1 undo, so Bob is back", clientRepo, None, None)
    undoController.undo()
    printReposWithMessage(
        "Another undo, so Sophia is back too", clientRepo, None, None)

    '''
    We redo once
    '''
    undoController.redo()
    printReposWithMessage(
        "1 redo, so Sophia is again deleted", clientRepo, None, None)


undoExampleMedium()
