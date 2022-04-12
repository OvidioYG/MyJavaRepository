package client;

//import java.util.ArrayList;
//import java.util.List;

import billingService.Bill;
import meal.items.*;
import service.*;
import visitorPatt.ticketGenerator.TxtTicketGeneratorVisitor;
import visitorPatt.ticketGenerator.Visitor;

public class ClientPatterns {
	public static void main(String[] args) {
		
		//Foods are created with a builder pattern
		//meals are created with a bridge pattern between Food and Beverages
		//Undo method is implemented as a memento inside Order
		//Factory method is implemented in Bill creation
		//Visitor method is implemented in 2 places, price creation for meals implemented inside Beverage and Food and 
		    //document generation classes
		   
		
		Order order1= new Order();                 // edit path in regards to your system
	    Visitor txt= new TxtTicketGeneratorVisitor("C:\\Users\\Ovidio\\Desktop\\JavaProject\\"); //txt file generator
                                                   
		
		Meal meal1= new FoodAndBev(new CustomBurger.BurgerBuilder().
				setNotes("lots of Ketchup and mustard").build(), new Water());
		
		Meal meal2= new OnlyFood(new SimpleBurger.BurgerBuilder().build());	
		
		Meal meal3= new FoodAndBev(new HotDog.HotDogBuilder()
				.setTopping("Ketchup")
			.setTopping("Mayo")
			.setTopping("Mustard").setSize('N').build(), new Coke());
		
		Meal meal4= new OnlyBeverage(new Water());
		
		
//		 List<Meal> meals = new ArrayList<>(); 
//		
//		meals.add(meal1);
//		meals.add(meal2);
//		meals.add(meal3);
//		meals.add(meal4); 
//		
//		Order order2= new Order(meals);   


	      order1.addMeal(meal1);   // for each add meal or remove the order creates a backup of it and its added unto an array
		  order1.addMeal(meal2);           //of mementos
		  order1.addMeal(meal3);
		  order1.addMeal(meal4);
		  order1.RemoveLastMeal();
	      order1.undo();                    // <--- Memento pattern
		  order1.orderStatus();
		  order1.accept(txt);   //used to create an order ticket in a txt file
		 
		
		 Bill bill= new Bill(order1);
		 bill.getBill();
		 bill.accept(txt);  //used to create a txt with the bill
		
		

	}
}
