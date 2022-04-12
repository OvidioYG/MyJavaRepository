package meal.items.priceVisitor;

import meal.items.*;
import meal.items.interfaces.Beverage;
import meal.items.interfaces.Food;

public class PriceGeneratorVisitor implements Visitor{
	
	private double price = 0.00;
	
	
	public double generatePrice(Beverage bev) {
		
		
		if(bev instanceof Coke)
			price = 20.00;
		
		if(bev instanceof Water)
			price = 10.00;
			
		
		return price;}
	
    public double generatePrice(Food food) {
    	if(food instanceof SimpleBurger) {
    		price = 60.00;
    	
    	}
    	
    	if(food instanceof CustomBurger) {
    		CustomBurger cBurger = (CustomBurger) food;
    		price = 80.00;
    		
    		if(cBurger.getNumberOfPatties()>1)
    			price += 20.00;
				
    	}
    	
    	
    	
    	if(food instanceof HotDog) {
    		HotDog hotdog= (HotDog) food;
    		
    		if(hotdog.getSize()=='N')
    			price = 40.00;
    		else if(hotdog.getSize()=='L')
    			price = 60;
    	
    		if(hotdog.gettoppings().size()>3)
    			price += (hotdog.gettoppings().size()-3)*5.00;
    	
    	}
    	
    	
		return price;
		
    }

}
