class Quadrilateral:
    def __init__(self, width,height):
        self._width = width
        self._height = height

    def area(self):
        pass

class Rectangle(Quadrilateral):
    def __init__(self, width, height):
        Quadrilateral.__init__(self,width,height)

    def area(self):
        return self._width * self._height
    
class Rhombus(Quadrilateral):
    def __init__(self, pdiag, qdiag):
        Quadrilateral.__init__(self,pdiag,qdiag)

    def area(self):
        return (self._width * self._height) / 2

class SquareOne(Rectangle, Rhombus):
    def __init__(self, width):
        Rectangle.__init__(self,width, width)

class SquareTwo(Rhombus,Rectangle):
    def __init__(self, width):
        Rectangle.__init__(self,width, width)

# Testing time
s1 = SquareOne(4)
s2 = SquareTwo(4)
print("SquareOne area = ",s1.area())
print("SquareTwo area = ",s2.area())

# What is the Method Resolution Order (MRO)
print(SquareTwo.__mro__)
print(SquareOne.__mro__)