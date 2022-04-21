package service;

import meal.items.interfaces.Beverage;
import meal.items.interfaces.Food;
//Bridge Pattern layer of abstraction
public abstract class Meal {
	
	private Food food;
	private Beverage beverage;
	private static int mealCounter=0;
	private int mealId=0;

	
	public Food getFood() {
		return food;}
	
	public void setFood(Food food) {
		this.food=food;}

	public Beverage getBeverage() {
		return beverage;}
	
	public void setBeverage(Beverage beverage) {
		this.beverage=beverage;}
	
	public int getMealId() {
		return mealId;}
	
	public void setMealId() {
		this.mealId= ++mealCounter;}
	
	public static int getMealCounter() {
		return mealCounter;}
	
	public static void resetMealCounter() {
		Meal.mealCounter=0;
	}

	
	
	@Override
	public String toString() {
		
		return  "\n"
				+"//////////////////////////////////////////" +"\n" +"\n"
				+"Meal " +mealId + "\n" +"\n"
				+ (food==null? " *No Food*":food)+ "\n" +"\n"
				
				+ "==============================" + "\n" + "\n"
				+ (beverage==null? " *No beverage*":beverage);
	}
	
	
	
	
	

	
	
	
	

}
