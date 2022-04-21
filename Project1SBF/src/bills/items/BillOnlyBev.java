package bills.items;

import billingService.Bills;
import service.Meal;


public class BillOnlyBev implements Bills{

   Meal meal;
	
	
	public BillOnlyBev(Meal meal) {
		this.meal = meal;
	}

	@Override
	public double calculatePrice() {
		double price = meal.getBeverage().getActualPrice();
		
		return price;
	}

	@Override
	public String toString() { 
		return  
				this.meal.getBeverage().getClass().getSimpleName() + "  :  " + this.meal.getBeverage().getActualPrice() + " $" ;
	}
	
	
	

}
