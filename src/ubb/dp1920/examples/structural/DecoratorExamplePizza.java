/**
 * This example is based on:
 * https://stackoverflow.com/questions/2707401/understand-the-decorator-pattern-with-a-real-world-example
 */
package ubb.dp1920.examples.structural;

/**
 * Simple, undecorated but tasty Pizza variations
 */
abstract class BasePizza {
    protected double myPrice;

    public double getPrice() {
        return this.myPrice;
    }
}

class Margherita extends BasePizza {
    public Margherita() {
        this.myPrice = 6.99;
    }
}

class Gourmet extends BasePizza {
    public Gourmet() {
        this.myPrice = 7.49;
    }
}

/**
 * Basic topping (decorator) for Pizza
 * Obviously, given Liskob substitution, you can apply these toppings (decorators) to all basic pizza types
 * That includes already topped? (decorated) pizzas
 */
abstract class PizzaWithTopping extends BasePizza {
    protected BasePizza pizza;

    public PizzaWithTopping(BasePizza pizzaToDecorate) {
        this.pizza = pizzaToDecorate;
    }

    public double getPrice() {
        return this.pizza.getPrice() + this.myPrice;
    }
}

class PizzaWithCheese extends PizzaWithTopping {
    public PizzaWithCheese(BasePizza pizzaToDecorate) {
        super(pizzaToDecorate);
        this.myPrice = 0.99;
    }
}

class PizzaWithMushrooms extends PizzaWithTopping {
    public PizzaWithMushrooms(BasePizza pizzaToDecorate) {
        super(pizzaToDecorate);
        this.myPrice = 1.49;
    }
}

class PizzaWithJalapeno extends PizzaWithTopping {
    public PizzaWithJalapeno(BasePizza pizzaToDecorate) {
        super(pizzaToDecorate);
        this.myPrice = 1.49;
    }
}

public class DecoratorExamplePizza {
    public static void main(String[] args) {
        Margherita pizza = new Margherita();
        System.out.println("Plain Margherita: " + Double.toString(pizza.getPrice()));

        PizzaWithCheese moreCheese = new PizzaWithCheese(pizza);
        PizzaWithCheese someMoreCheese = new PizzaWithCheese(moreCheese);

        System.out.println("Plain Margherita with double extra cheese: " + Double.toString(someMoreCheese.getPrice()));

        PizzaWithMushrooms moreMushroom = new PizzaWithMushrooms(someMoreCheese);
        System.out.println(
                "Plain Margherita with double extra cheese with mushroom: " + Double.toString(moreMushroom.getPrice()));

        PizzaWithJalapeno moreJalapeno = new PizzaWithJalapeno(moreMushroom);
        System.out.println("Plain Margherita with double extra cheese with mushroom with Jalapeno: "
                + Double.toString(moreJalapeno.getPrice()));
    }
}