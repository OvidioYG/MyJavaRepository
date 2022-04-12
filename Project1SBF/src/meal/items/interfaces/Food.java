package meal.items.interfaces;

import meal.items.priceVisitor.PriceGeneratorVisitor;
import meal.items.priceVisitor.Visitant;
import meal.items.priceVisitor.Visitor;

public abstract class Food implements Visitant{
	
	public abstract String toString();
	
	//this method is the accept method from the visitant class renamed, in this we have a fixed PricedGenerator (visitor child)
		public double getActualPrice() {
			Visitor priceVisitor = new PriceGeneratorVisitor();
			return priceVisitor.generatePrice(this);
		}
		
		//this method is an overload of the getActualPrice, used to use a different instance or variant of Visitor method
		public  double getActualPrice(Visitor visitor) {
			return visitor.generatePrice(this);
		}
	
	
	

}
