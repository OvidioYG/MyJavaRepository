package service;

import meal.items.interfaces.Beverage;
//refined abstraction
public class OnlyBeverage extends Meal{
	
	public OnlyBeverage(Beverage beverage) {
	
		
		this.setFood(null);
		this.setBeverage(beverage);
		this.setMealId();
		
	//	System.out.println("*  Beverage Meal was created" + "\n");
		System.out.println("*  meal created");
	}
	
	
	

}
