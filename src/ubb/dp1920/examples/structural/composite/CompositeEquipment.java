package ubb.dp1920.examples.structural.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is the composite for the same-name design pattern
 */
class CompositeEquipment extends Equipment {
    private List<Equipment> equipments;

    public CompositeEquipment(String name, int power, int price) {
        super(name, power, price);
        equipments = new ArrayList<>();
    }

    public int getPower() {
        int totalPower = this.power;
        Iterator<Equipment> iter = iterator();
        while (iter.hasNext()) {
            totalPower += iter.next().getPower();
        }
        return totalPower;
    }

    public int getPrice() {
        int totalPrice = this.price;
        Iterator<Equipment> iter = iterator();
        while (iter.hasNext()) {
            totalPrice += iter.next().getPrice();
        }
        return totalPrice;
    }

    public void add(Equipment eq) {
        equipments.add(eq);
        // Hierarchical Chain of Responsibility
        eq.setNext(this);

    }

    public void remove(Equipment eq) {
        equipments.remove(eq);
    }

    public Iterator<Equipment> iterator() {
        return equipments.iterator();
    }
}