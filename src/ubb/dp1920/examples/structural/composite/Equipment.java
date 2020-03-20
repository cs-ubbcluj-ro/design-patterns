package ubb.dp1920.examples.structural.composite;

import java.util.Iterator;

/**
 * 
 * Abstract base class for equipment
 *
 */
public abstract class Equipment extends DiagnosticHandler implements Iterable<Equipment> {
    private String name;
    protected int power;
    protected int price;

    public Equipment(String name, int power, int price) {
        this.name = name;
        this.power = power;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }

    public abstract void add(Equipment eq);

    public abstract void remove(Equipment eq);

    public abstract Iterator<Equipment> iterator();
}