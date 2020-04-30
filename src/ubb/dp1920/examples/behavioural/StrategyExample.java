package ubb.dp1920.examples.behavioural;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ubb.dp1920.examples.structural.composite.CPU;
import ubb.dp1920.examples.structural.composite.Equipment;
import ubb.dp1920.examples.structural.composite.MemoryModule;
import ubb.dp1920.examples.structural.composite.VideoCard;

/**
 * Abstract base class for a payment strategy
 */
abstract class PaymentStrategy {
    // Raise Exception in case payment error is encountered
    public abstract void registerPayment(int totalSum) throws Exception;
}

class CreditCardPayment extends PaymentStrategy {
    @Override
    public void registerPayment(final int totalSum) throws Exception {
        // mock-up
        System.out.println("Paying " + totalSum + " using credit card");
        System.out.println("Give card number:");
        System.console().readLine();
        System.out.println("Give name on card:");
        System.console().readLine();
        System.out.println("Give CVV:");
        System.console().readLine();
    }
}

class PayPalPayment extends PaymentStrategy {
    @Override
    public void registerPayment(final int totalSum) throws Exception {
        System.out.println("Paying " + totalSum + " using PayPal");
        System.out.println("Give account:");
        System.console().readLine();
        System.out.println("Give payment code:");
        System.console().readLine();
    }
}

public class StrategyExample {
    public static void main(final String[] args) {
        final List<Equipment> equipments = new ArrayList<>();
        final List<Equipment> purchases = new ArrayList<>();

        // Let's add some PC equipment
        equipments.add(new CPU("Intel i7 CPU", 95, 380));
        equipments.add(new CPU("AMD Ryzen 5", 65, 265));
        equipments.add(new VideoCard("AMD Radeon 560X", 75, 120));
        equipments.add(new VideoCard("nVidia RTX 2060", 160, 390));
        equipments.add(new MemoryModule("Generic 8Gb module", 3, 95));
        equipments.add(new MemoryModule("Generic 16Gb module", 5, 215));

        boolean done = false;
        while (!done) {
            // Handle the menu
            System.out.println("What would you like to buy?");
            int i = 0;
            while (i < equipments.size()) {
                System.out.println("\t" + Integer.toString(i) + " - " + equipments.get(i).getName());
                i += 1;
            }
            System.out.println("9 - Done");
            final int choice = Integer.parseInt(System.console().readLine());
            if (choice == 9) {
                done = true;
            } else if (choice < 0 || choice >= equipments.size()) {
                System.out.println("No equipment at that position!");
            } else {
                // Remove from equipments and add to purchases
                purchases.add(equipments.remove(choice));
            }
        }

        // Calculate total cost of purchase
        int total = 0;
        final Iterator<Equipment> it = purchases.iterator();
        while (it.hasNext()) {
            total += it.next().getPrice();
        }

        // Ask for payment
        System.out.println("How will you pay? \n 1 - Credit Card\n 2 - PayPal\n");
        final int choice = Integer.parseInt(System.console().readLine());

        PaymentStrategy ps = null;
        switch (choice) {
            case 1:
                ps = new CreditCardPayment();
                break;

            default:
                ps = new PayPalPayment();
                break;
        }

        try {
            // At this point we use a payment strategy
            ps.registerPayment(total);
        } catch (final Exception e) {
            System.out.println("Error encountered during payment: ");
            e.printStackTrace();
        }
    }
}
