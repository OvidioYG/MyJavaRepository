package visitorPatt.ticketGenerator;

import billingService.Bill;
import service.Order;

public interface Visitor {
	
	public abstract void generate(Order order);
	
	public abstract void generate(Bill bill);

}
