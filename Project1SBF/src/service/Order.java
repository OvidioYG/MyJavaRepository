package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mementoPattOrder.Caretaker;
import mementoPattOrder.Memento;
import visitorPatt.ticketGenerator.Visitant;
import visitorPatt.ticketGenerator.Visitor;


public class Order implements Visitant{
	
	private List<Meal> listOfMeals;
	private String orderId="O";
	private static int orderCounter=0;
	private Caretaker stateList;
	
	

	public Order() {
		this.listOfMeals = new ArrayList<>();
		Meal.resetMealCounter();
		this.orderId=orderId.concat("-"+ ++orderCounter);
		this.stateList=new Caretaker();
		System.out.println("\nOrder " + this.orderId + " created!" );
		System.out.println("insert meals" +"\n");
	}
	
	public Order(List<Meal> meals) {
		
		this.listOfMeals = meals;
		Meal.resetMealCounter();
		this.orderId=orderId.concat("-"+ ++orderCounter);
		this.stateList=new Caretaker();
		System.out.println("\nOrder " + this.orderId + " created!" );
		System.out.println("meals in Order: " + meals.size()+"\n");
			
	}
	
	public static int getOrderCounter() {
		return orderCounter;}
	
	
	public void addMeal(Meal meal) {
		System.out.println();
		listOfMeals.add(meal);
		System.out.println("+  new meal added" );
		this.stateList.push(new Memento(listOfMeals));
		//orderStatus();
		
	}
	
	public void RemoveLastMeal() {
		
		try {
	    System.out.println();
		listOfMeals.remove(listOfMeals.size()-1);
		System.out.println("-  last meal removed" );
		this.stateList.push(new Memento(listOfMeals));
		//orderStatus();
		
		}catch(Exception e) {
			System.out.println("there are no meals to be removed");
		}
		
	}
	
	public Order undo() {
		
		try {
		System.out.println();
		listOfMeals = stateList.pop();
		System.out.println("<- The order has been reversed to its previous state" );
		//orderStatus();
		
		
		}catch(Exception e){
			System.out.println("There is no previous state of the order");
		}
		
		return this;
	}
	
	public Order Empty() {
		System.out.println();
		listOfMeals.clear();
		System.out.println("All meals have been cleared" );
		
		return this;
	}
	
	public List<Meal> getMealList(){
		return this.listOfMeals;}
	
	
	public void orderStatus() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		
		Iterator<Meal> items=listOfMeals.iterator();
		
		StringBuilder mealsString= new StringBuilder();
		
		while(items.hasNext())
		mealsString.append(items.next() + "\n");
		
		
		String status;
		
		status =   "..................................................................................." + "\n"
		         + "Status" + "\n"
			     + "Order ID = " + orderId + "\n"
		         + mealsString +"\n";
				
		return  status;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.generate(this);
		
	}
	
	



}
