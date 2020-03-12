package ubb.dp1920.examples.solid.interfacesegregation;

public class Configuration {
	private int coffee;
	private int water;

	public Configuration(int coffee, int water) {
		this.coffee = coffee;
		this.water = water;
	}

	public int getQuantityCoffee() {
		return coffee;
	}

	public int getQuantityWater() {
		return water;
	}
}
