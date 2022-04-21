package service;

import meal.items.interfaces.Food;
//refined abstraction
public class OnlyFood extends Meal{
	
	public OnlyFood(Food food) {
		
		this.setFood(food);
		this.setBeverage(null);
		this.setMealId();
		
		// System.out.println("*  Food Meal was created" + "\n");
		System.out.println("*  meal created");
	}

}
