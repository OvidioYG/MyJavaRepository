package meal.items.priceVisitor;

public interface Visitant{
	
	//accept methods renamed to getActualPrice
	   public double getActualPrice(Visitor visitor);
	   public double getActualPrice();
		
	

}
