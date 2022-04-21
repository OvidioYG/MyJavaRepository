package billingService;

import java.util.List;

import bills.items.BillFoodWithBev;
import bills.items.BillOnlyBev;
import bills.items.BillOnlyFood;

import java.util.ArrayList;


import service.Meal;

import service.*;


public class BillFactory {
	
	
	


	public static List<Bills> creatBill(List<Meal> meals) {
		
		List<Bills> billList = new ArrayList<>();
		
		
		for(Meal m : meals) {
		
			if(m instanceof FoodAndBev)
				 billList.add(new BillFoodWithBev(m));
			if(m instanceof OnlyFood)
				billList.add(new BillOnlyFood(m)); 
			if(m instanceof OnlyBeverage)
				billList.add(new BillOnlyBev(m));
			
		}
			
	
		return billList;
		}
		
	
	
	
	

	
	

}
