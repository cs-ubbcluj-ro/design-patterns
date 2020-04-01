class Car:
    def __init__(self, objectId, licenseNumber, make, model):
        self._id = objectId
        self._license = licenseNumber
        self._make = make
        self._model = model

    @property
    def id(self):
        return self._id

    @property
    def license(self):
        return self._license

    @property
    def make(self):
        return self._make

    @property
    def model(self):
        return self._model
    
    def __eq__(self, z):
        if isinstance(z, Car) == False:
            return False
        return self.id == z.id

    def __str__(self):
        return "Id: " + str(self.id) + ", License: " + self.license + ", Car type: " + self.make + ", " + self.model

    def __repr__(self):
        return str(self)