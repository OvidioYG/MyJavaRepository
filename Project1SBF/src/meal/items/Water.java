package meal.items;

import meal.items.interfaces.Beverage;

public class Water extends Beverage{
	
	private final String name="Bottled Water";

	@Override
	public String toString() {
		return "  Beverage:"+ " bottled water";
		
	}

	public String getName() {
		return name;
	}
	
	


	
}
