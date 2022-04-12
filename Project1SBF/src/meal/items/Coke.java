package meal.items;


import meal.items.interfaces.Beverage;




public class Coke extends Beverage{
	
	private final String name="Coke";

	@Override
	public String toString() {
		return "  Beverage:"+ " Coke";
	}

	public String getName() {
		return name;
	}

	

	

	

	
}
