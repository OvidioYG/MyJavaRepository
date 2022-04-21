package meal.items;

import meal.items.interfaces.Burger;

//Builder
public class SimpleBurger extends Burger {
	
	private boolean toppings;
	
	
	
	private SimpleBurger(String bread, String patty, boolean toppings, boolean cheese) {
		
		super(bread,patty,cheese);
		this.toppings=toppings;

	}
	
	
			public boolean isToppings() {
				return toppings;}

			@Override
			public String toString() {
				return    "  SimpleBurger:" + "\n" 
						+ "------------------------------" +"\n"
			            + " bread           = " + getBread() + "\n"
						+ " patty           = " + getPatty() + "\n"
						+ "------------------------------" +"\n"
						+ " cheese     : " + (isCheese()? "with cheese":"no cheese") +"\n"
						+ " toppings   : " + (toppings? "with all toppings":"no toppings") +"\n" ;	
			}
			
			
			
			public static class BurgerBuilder {
				
				private final String  bread = "Burger Bun";
				private final String  patty = "Beef";
				private boolean toppings = true;
				private boolean cheese  = true;
				
				
				public BurgerBuilder() {}
			
				
				public BurgerBuilder setToppings(boolean toppings) {
					this.toppings = toppings;
					return this;}
				
				public BurgerBuilder setCheese(boolean cheese) {
					this.cheese = cheese;
					return this;}
				
				
				public SimpleBurger build() {
					return new SimpleBurger(bread, patty, toppings, cheese);
				}
	
				
	
	}
}
