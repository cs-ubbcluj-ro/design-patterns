package ubb.dp1920.examples.structural.composite;

import java.util.Iterator;

/**
 * Base class for everything that is NOT a composite equipment
 */
class SimpleEquipment extends Equipment {
    public SimpleEquipment(String name, int power, int price) {
        super(name, power, price);
    }

    /**
     * These operations don't make sense for non-composite equipment
     */
    @Override
    public void add(Equipment eq) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Equipment eq) {
    }

    /**
     * A NullIterator in essence
     */
    @Override
    public Iterator<Equipment> iterator() {
        return new Iterator<Equipment>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Equipment next() {
                return null;
            }
        };
    }
}