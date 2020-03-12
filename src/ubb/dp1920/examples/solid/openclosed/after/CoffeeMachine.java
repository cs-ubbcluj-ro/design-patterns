package ubb.dp1920.examples.solid.openclosed.after;

import ubb.dp1920.examples.solid.openclosed.common.Coffee;
import ubb.dp1920.examples.solid.openclosed.common.CoffeeException;
import ubb.dp1920.examples.solid.openclosed.common.CoffeeSelection;

public interface CoffeeMachine {
	Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}