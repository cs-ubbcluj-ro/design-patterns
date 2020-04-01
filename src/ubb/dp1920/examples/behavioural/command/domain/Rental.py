from datetime import date


class Rental:
    def __init__(self, rentalId, start, end, client, car):
        self._id = rentalId
        self._client = client
        self._car = car
        self._start = start
        self._end = end

    @property
    def id(self):
        return self._id

    @property
    def client(self):
        return self._client

    @property
    def car(self):
        return self._car

    @property
    def start(self):
        return self._start

    @property
    def end(self):
        return self._end

    def __len__(self):
        return (self._end - self._start).days + 1

    def __repr__(self):
        return str(self)

    def __str__(self):
        return "Rental: " + str(self.id) + "\nCar: " + str(self.car) + "\nClient: " + str(self.client) + "\nPeriod: " + self.start.strftime("%Y-%m-%d") + " to " + self.end.strftime("%Y-%m-%d")
