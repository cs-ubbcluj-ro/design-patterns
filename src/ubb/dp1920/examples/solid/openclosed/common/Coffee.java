package ubb.dp1920.examples.solid.openclosed.common;

public class Coffee {

	private String name;
	private int quantity;

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Coffee(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;

	}
}
