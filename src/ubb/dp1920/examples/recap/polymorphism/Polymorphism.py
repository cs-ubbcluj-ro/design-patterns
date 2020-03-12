class Animal(object):
    def talk(self):
        print("?")

class Dog(Animal):
    def talk(self):
        print("woof woof!")

class Cat(Animal):
    def talk(self):
        print("meow!")

a = Animal()
c = Cat()
d = Dog()

a.talk()
c.talk()
d.talk()

# Both value AND type are transferred 
a = c
c.talk()