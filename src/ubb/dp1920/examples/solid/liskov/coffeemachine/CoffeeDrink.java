/*
 * Example source code:
 * https://github.com/thjanssen/Stackify-SOLID-Liskov
 */
package ubb.dp1920.examples.solid.liskov.coffeemachine;

public class CoffeeDrink {

	private CoffeeSelection selection;
	
	private double quantity;

	public CoffeeDrink (CoffeeSelection selection, double quantity) {
		this.selection = selection;
		this.quantity = quantity;
	}
	
	public CoffeeSelection getSelection() {
		return selection;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) throws CoffeeException {
		if (quantity >= 0.0) {
			this.quantity = quantity;
		} else {
			throw new CoffeeException("Quantity has to be >= 0.0.");
		}
	}
}
