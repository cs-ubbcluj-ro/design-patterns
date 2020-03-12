using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Animal
{
    /*
	Try with/without using the "virtual" keyword here
	What if the animal cannot "talk"?
	*/
    public virtual void talk()
    {
        Console.WriteLine("animal");
    }
};

class Cat : Animal
{
    public override void talk()
    {
        Console.WriteLine("meow");
    }
};

class Dog : Animal
{
    public override void talk()
    {
        Console.WriteLine("woof woof!");
    }
};


class Program
{
    static void Main(String[] args)
    {
        Console.WriteLine("C# Version");
        //1. Use pointers to direct classes
        Animal a = new Animal();
        Cat c = new Cat();
        Dog d = new Dog();
        Console.WriteLine("Pointers to class itself");
        a.talk();
        c.talk();
        d.talk();

        //2. Use pointers to the base class
        Console.WriteLine("Pointers to base class");
        a = c;
        a.talk();
    }
}