package meal.items.priceVisitor;

import meal.items.interfaces.Beverage;
import meal.items.interfaces.Food;

public interface Visitor {
	
	public double generatePrice(Beverage bev);
	public double generatePrice(Food food);

}
