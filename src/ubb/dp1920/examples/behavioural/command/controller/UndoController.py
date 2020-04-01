'''
The UndoController receives command objects (both simple and compound) from the Controllers
It keeps a history list of operations
The UI tells it when to call these stored commands
'''
class UndoController:
    def __init__(self):
        # 
        # History list of operations for undo/redo
        #
        self._operations = []
        self._index = -1    
        self._duringCallback = False

    def recordOperation(self, cascadedOp):
        if self._duringCallback == True:
            return

        '''
        No redos after a new operation
        '''
        self._operations = self._operations[0:self._index + 1]

        '''
            Add the new cascaded operation
        '''
        self._operations.append(cascadedOp)
        self._index += 1

    def undo(self):
        if self._index < 0:
            return False

        self._duringCallback = True
        self._operations[self._index].undo()
        self._duringCallback = False
        self._index -= 1
        return True
    
    def redo(self):
        if self._index + 1 >= len(self._operations):
            return False
        self._duringCallback = True
        self._index += 1
        self._operations[self._index].redo()
        self._duringCallback = False
        return True             

class FunctionCall:
    def __init__(self, functionRef, *parameters):
        self._functionRef = functionRef
        self._parameters = parameters

    def call(self):
        self._functionRef(*self._parameters)

"""
Represents a non-compound Command object
"""
class Operation:
    def __init__(self, functionDo, functionUndo):
        self._functionDo = functionDo
        self._functionUndo = functionUndo

    def undo(self):
        self._functionUndo.call()

    def redo(self):
        self._functionDo.call()

"""
Represents a compound Command object
"""
class CascadedOperation:
    def __init__(self, op=None):
        self._operations = []
        
        if op != None:
            self.add(op)
            
    def add(self, op):
        self._operations.append(op)

    def undo(self):
        for i in range(len(self._operations) - 1, -1, -1):
            self._operations[i].undo()

    def redo(self):
        for i in range(len(self._operations) - 1, -1, -1):
            self._operations[i].redo()