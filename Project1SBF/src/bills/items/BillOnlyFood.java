package bills.items;

import billingService.Bills;
import service.Meal;

public class BillOnlyFood implements Bills{
	
	Meal meal;
	
	
	public BillOnlyFood(Meal meal) {
		this.meal = meal;
	}

	@Override
	public double calculatePrice() {
		double price = meal.getFood().getActualPrice();
		
		return price;
	}

	@Override
	public String toString() {
		return this.meal.getFood().getClass().getSimpleName() + "  :  " + this.meal.getFood().getActualPrice() + " $" ;
	}
	
	

}
