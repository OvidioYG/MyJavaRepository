package visitorPatt.ticketGenerator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import billingService.Bill;
import service.Order;



public class TxtTicketGeneratorVisitor implements Visitor{
	
	private String path="";
	
	
	public TxtTicketGeneratorVisitor(){
		System.out.println("Default path for ticket used");
	}
	
	public TxtTicketGeneratorVisitor(String path){
		this.path = path;
	}

	
	public void generate(Order order) {

		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.path+ "order_" + Order.getOrderCounter() +".txt"));
			System.out.println("Order ticket was generated!");
			System.out.println("Ticket can be found in: "+ this.path);
			writer.write(order.toString());
			writer.close();
			
		} catch (IOException e) {
			System.out.println("ticket wasn't generated");}
		
	}
	
	
	
    public void generate(Bill bill) {
		
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.path+ "bill_" + Order.getOrderCounter() +".txt"));
			System.out.println("Bill ticket was generated!");
			System.out.println("Ticket can be found in: "+ this.path);
			writer.write(bill.toString());
			writer.close();
			
		} catch (IOException e) {
			System.out.println("ticket wasn't generated");}
		
	}

	
	
    
}
