package ubb.dp1920.examples.recap.polymorphism;

class Animal {
    public void talk() {
        System.out.println("animal");
    }
};

class Cat extends Animal {
    public void talk() {
        System.out.println("meow");
    }
};

class Dog extends Animal {
    public void talk() {
        System.out.println("woof woof!");
    }
};

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("Java sample");
        // References to direct classes
        Animal a = new Animal();
        Cat c = new Cat();
        Dog d = new Dog();
        System.out.println("Pointers to class itself");
        a.talk();
        c.talk();
        d.talk();

        // References to the base class
        System.out.println("Pointers to base class");
        a = c;
        a.talk();
    }
}