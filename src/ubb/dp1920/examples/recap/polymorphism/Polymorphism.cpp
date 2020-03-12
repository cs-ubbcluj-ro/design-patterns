#include "stdafx.h"
#include <iostream>
using namespace std;

class Animal {
public:
	/*
	Try with/without using the "virtual" keyword here
	What if the animal cannot "talk"?
	*/
	virtual void talk() {
		cout << "animal" << endl;
	};
};

class Cat : public Animal {
public:
	void talk() {
		cout << "meow!" << endl;
	};
};

class Dog : public Animal {
public:
	void talk() {
		cout << "woof woof!" << endl;
	};
};

int main()
{
	cout << "C++ version"<<endl;
	//1. Use pointers to direct classes
	Animal* a = new Animal();
	Cat* c = new Cat();
	Dog* d = new Dog();
	cout << "Pointers to class itself"<<endl;
	a->talk();
	c->talk();
	d->talk();

	//2. Use pointers to the base class
	cout << "Pointers to base class"<<endl;
	a = c;
	a->talk();
	return 0;
}