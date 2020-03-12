#include<iostream>
using namespace std;

class Animal
{
private:
	int weight;

public:
	virtual int getWeight()
	{
		return weight;
	}
	virtual ~Animal() {};
};

class Lion : virtual public Animal
{

};

class Tiger : virtual public Animal
{

};

class Liger : public Lion, public Tiger
{
};

int main(int argc, char const *argv[])
{
	Liger liger;
	// The following method call is ambiguous. There is a getWeight() from Animal::Tiger, and one from Animal::Lion
	// You can solve it using virtual inheritance, or static casts
	// int w = liger.getWeight();

	// Get Animal:Tiger's getWeight() method
	Animal &tiger = static_cast<Tiger&>(liger);
	int w = tiger.getWeight();
	int x;
	//cin >> x;
	return 0;
}
