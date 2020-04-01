class Client:
    def __init__(self, clientId, cnp, name):
        self._id = clientId
        self._cnp = cnp
        self._name = name

    @property 
    def id(self):
        return self._id
    
    @property 
    def cnp(self):
        return self._cnp

    @property
    def name(self):
        return self._name

    def __eq__(self, z):
        if isinstance(z, Client) == False:
            return False
        return self.id == z.id

    def __str__(self):
        return "Id=" + str(self.id) + ", Name=" + str(self.name)
    
    def __repr__(self):
        return str(self)
