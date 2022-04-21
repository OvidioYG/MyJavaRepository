package bills.items;

import billingService.Bills;
import service.Meal;


public class BillFoodWithBev implements Bills {

    Meal meal;
    double comboDiscount= 15.00;
	
	
	public BillFoodWithBev(Meal meal) {
		this.meal = meal;
	}

	@Override
	public double calculatePrice() {
		double price = meal.getBeverage().getActualPrice() + meal.getFood().getActualPrice() - comboDiscount;
		
		return price;
	}

	@Override
	public String toString() {
		return 
			 this.meal.getFood().getClass().getSimpleName()  + " : "
		   + this.meal.getFood().getActualPrice() + " $ " + "\n"
		   + this.meal.getBeverage().getClass().getSimpleName() + " : " 
		   + this.meal.getBeverage().getActualPrice() + " $ " + "\n" +
		   "Total cost of Meal with a combo discount of " + comboDiscount + "$" +" : " + calculatePrice() + " $";
		   
	}

	
		
		
		
		
		
		
	
	
	

}
