package ubb.dp1920.examples.solid.interfacesegregation;

import java.util.HashMap;
import java.util.Map;

class BasicCoffeeMachine implements CoffeeMachine {

	private Map<CoffeeSelection, Configuration> configMap;
	private GroundCoffee groundCoffee;
	private BrewingUnit brewingUnit;

	public BasicCoffeeMachine(GroundCoffee coffee) {
		this.groundCoffee = coffee;
		this.brewingUnit = new BrewingUnit();

		this.configMap = new HashMap<>();
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
	}

	@Override
	public CoffeeDrink brewFilterCoffee() {
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

		// brew a filter coffee
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, this.groundCoffee, config.getQuantityWater());
	}

	@Override
	public void addGroundCoffee(GroundCoffee newCoffee) throws CoffeeException {
		if (this.groundCoffee != null) {
			if (this.groundCoffee.getName().equals(newCoffee.getName())) {
				this.groundCoffee.setQuantity(this.groundCoffee.getQuantity() + newCoffee.getQuantity());
			} else {
				throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
			}
		} else {
			this.groundCoffee = newCoffee;
		}
	}

	@Override
	public CoffeeDrink brewEspresso() throws CoffeeException {
		throw new CoffeeException("This machine only brew filter coffee.");
	}
}