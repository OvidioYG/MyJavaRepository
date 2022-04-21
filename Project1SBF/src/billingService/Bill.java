package billingService;

import java.util.List;

import service.Meal;
import service.Order;
import visitorPatt.ticketGenerator.Visitant;
import visitorPatt.ticketGenerator.Visitor;

public class Bill implements Visitant{
	
	private List<Meal> mealL;
	private List<Bills> bills;
	
	public Bill(Order order) {
		System.out.println("\n" + "Bill for the Order " + Order.getOrderCounter() + " was generated!");
		this.mealL = order.getMealList();
		this.bills = BillFactory.creatBill(this.mealL);
	}
	
	public void getBill() {
		System.out.println(this.toString());
	}
	

	@Override
	public String toString() {
		
		StringBuilder strBill= new StringBuilder();
		int mCounter = 0;
		
		double totalSum = 0.00;
		double discount = .15;
		boolean flag = false;
		
		
		for(Bills b : bills) {
			totalSum += b.calculatePrice();
			strBill.append("Meal "+ ++mCounter + "\n" + b + "\n" + "\n");
			}
			
		if(bills.size()>3) { 
			totalSum *= 1 - discount;
			flag = true;
				
			
			
		}
		
		    return     "................................................................." + "\n" 
				     + "  BILL" + "\n" 
				     + "|+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|" + "\n" 
				     + "\n" 
				     + strBill 
				     + "\n"
				     +  "|+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|" + "\n" + "\n"
				     + "The total Price of the order is : "+ String.format("%.2f",totalSum) + "$"+ "\n"
				     + (flag? ("The Order had more than 3 meals, a discount of " + discount + "%" + "  was applied!") : "") + "\n"
				     + "..................................................................";
	}




	@Override
	public void accept(Visitor visitor) {
		visitor.generate(this);
		
	}
	
	
	
	
	
	

}
