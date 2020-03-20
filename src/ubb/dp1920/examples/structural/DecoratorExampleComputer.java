package ubb.dp1920.examples.structural;

import java.util.Iterator;

import ubb.dp1920.examples.structural.composite.CPU;
import ubb.dp1920.examples.structural.composite.Chassis;
import ubb.dp1920.examples.structural.composite.Equipment;
import ubb.dp1920.examples.structural.composite.MemoryModule;
import ubb.dp1920.examples.structural.composite.RAIDController;
import ubb.dp1920.examples.structural.composite.SSD;
import ubb.dp1920.examples.structural.composite.VideoCard;

/**
 * This is a decorator for the computer chassis, adding a light Its returned
 * power and price reflect the new addition
 */
class ChassisWithRGBLight extends Chassis {
    Chassis chassis;

    public ChassisWithRGBLight(Chassis chassis) {
        super(chassis.getName(), chassis.getPower(), chassis.getPrice());
        this.chassis = chassis;
    }

    @Override
    public void add(Equipment eq) {
        chassis.add(eq);
    }

    @Override
    public void remove(Equipment eq) {
        chassis.remove(eq);
    }

    @Override
    public int getPower() {
        // 3W added for the RGB lighting
        return chassis.getPower() + 3;
    }

    @Override
    public int getPrice() {
        // 20 EUR added for lighting
        return super.getPrice() + 20;
    }

    @Override
    public Iterator<Equipment> iterator() {
        return chassis.iterator();
    }
}

class VideoCardWithRGBLight extends VideoCard {
    private VideoCard card;

    public VideoCardWithRGBLight(VideoCard card) {
        super(card.getName(), card.getPrice(), card.getPower());
        this.card = card;
    }

    /**
     * Methods of SimpleEquipment are not implemented as they do nothing
     */
}

public class DecoratorExampleComputer {
    public static void main(String[] args) {
        /**
         * Create an RGB decorated desktop
         */

        // Did we overdo it?
        Equipment desktop = new ChassisWithRGBLight(
                new ChassisWithRGBLight(new Chassis("My gaming battlestation", 15, 150)));
        desktop.add(new CPU("Intel 9900K", 450, 95));

        Equipment raid = new RAIDController("RAID0", 50, 5);
        raid.add(new SSD("Samsung 850 EVO", 200, 3));
        raid.add(new SSD("Samsung 850 EVO", 200, 3));
        desktop.add(raid);

        desktop.add(new VideoCardWithRGBLight(new VideoCard("GTX 1080", 445, 180)));
        desktop.add(new MemoryModule("8Gb", 250, 2));
        desktop.add(new MemoryModule("8Gb", 250, 2));

        /**
         * Compare the power consumption and price with those from the
         * CompositeExample.java
         */
        System.out.println("Decorated Battlestation price is " + Integer.toString(desktop.getPrice())
                + ", power consumption is " + Integer.toString(desktop.getPower()) + "W");
    }
}