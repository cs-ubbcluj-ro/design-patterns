#
# Incomplete List adapter class
#


class ListAdapter:
    def __init__(self):
        self.__data = []

    def __add__(self, elem):
        self.__data.append(elem)

    def delete(self, index):
        self.__data.pop(index)

    def get(self, index):
        return self.__data[index]

    def __len__(self):
        return len(self.__data)

    def __iter__(self):
        class ListAdapterIter:
            def __init__(self, target):
                self.__target = target
                self.__index = 0

            def __next__(self):
                if self.__index >= len(self.__target):
                    raise StopIteration()
                self.__index += 1
                return self.__target.get(self.__index - 1)

        return ListAdapterIter(self)


def main():
    lst = ListAdapter()
    for i in ['Anna', 'Betty', 'Charles', 'Deckard']:
        lst + i

    for name in lst:
        print(name)


main()
