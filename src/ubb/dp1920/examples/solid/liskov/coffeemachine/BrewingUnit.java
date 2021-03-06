/*
 * Example source code:
 * https://github.com/thjanssen/Stackify-SOLID-Liskov
 */
package ubb.dp1920.examples.solid.liskov.coffeemachine;

public class BrewingUnit {

	public CoffeeDrink brew(CoffeeSelection selection, GroundCoffee groundCoffee,
			double quantity) {
		return new CoffeeDrink(selection, quantity);
	}

}
