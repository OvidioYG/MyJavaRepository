package service;

import meal.items.interfaces.Beverage;
import meal.items.interfaces.Food;

public class FoodAndBev extends Meal{
	
	//refined abstraction
	public FoodAndBev(Food food, Beverage beverage) {
		
		this.setFood(food);
		this.setBeverage(beverage);
		this.setMealId();
		
		//System.out.println("*  Combo Meal was created"  +"\n");
		  System.out.println("*  meal created");
	}
	

}
