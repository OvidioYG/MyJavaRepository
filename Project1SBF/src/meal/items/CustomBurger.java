package meal.items;

import meal.items.interfaces.Burger;

//Builder
public class CustomBurger extends Burger {
	
	
	private int     numberOfPatties;
	private boolean tomato, lettuce;
	private boolean ketchup, mayonnaise, mustard;
	private String  notes;
	
	private CustomBurger(String bread, String patty, int numberOfPatties, boolean cheese, boolean tomato, boolean lettuce,
			boolean catsup, boolean mayonnaise, boolean mustard, String notes) {
		
		super(bread,patty,cheese);
		this.numberOfPatties = numberOfPatties;
		this.tomato = tomato;
		this.lettuce = lettuce;
		this.ketchup = catsup;
		this.mayonnaise = mayonnaise;
		this.mustard = mustard;
		this.notes = notes;
	}
	
	
	// we only need patties getter function for price calculation, but for bill we need all the attributes
	
			public int getNumberOfPatties() {
				return numberOfPatties;}
		
		
			public boolean isTomatoe() {
				return tomato;}
		
		
			public boolean isLettuce() {
				return lettuce;}
		
		
			public boolean isCatsup() {
				return ketchup;}
		
		
			public boolean isMayonnaise() {
				return mayonnaise;}
		
		
			public boolean isMustard() {
				return mustard;}
		
		
			public String getNotes() {
				return notes;}


			@Override
			public String toString() {
				return    "  CustomBurger:" + "\n"
						+ "------------------------------" +"\n"
			            + " bread           = " + getBread() + "\n"
						+ " patty           = " + getPatty() + "\n"
						+ " numberOfPatties = " + numberOfPatties + "\n"
						+ "------------------------------" +"\n"
						+ " cheese     : " + (isCheese()? "with cheese":"no cheese") + "\n"
						+ " tomatoe    : " + (tomato? "with tomato":"no tomatoe") + "\n"
						+ " lettuce    : " + (lettuce? "with lettuce":"no lettuce") + "\n"
						+ " ketchup    : " + (ketchup? "with ketchup":"no Ketchup") + "\n"
						+ " mayonnaise : " + (mayonnaise? "with mayonnaise":"no mayonnaise") + "\n"
						+ " mustard    : " + (mustard? "with mustard":"no mustard")+ "\n"
						+ " notes      : " + (notes.isBlank()? "-No notes-":notes );
			}
			
			
			
			public static class BurgerBuilder {
				
				private String  bread = "Burger Bun";
				private String  patty = "Beef";
				private int     numberOfPatties = 1;
				private boolean cheese  = true;
				private boolean tomato = true, lettuce  = true;
				private boolean ketchup  = true, mayonnaise = true, mustard = true;
				private String  notes ="";
				
				public BurgerBuilder() {}
				
				public BurgerBuilder setBread(String bread) {
					this.bread = bread;
					return this;}
				
				public BurgerBuilder setPatty(String patty) {
					this.patty = patty;
					return this;}
				
				public BurgerBuilder setNumberOfPatties(int numberOfPatties) {
					this.numberOfPatties = numberOfPatties;
					return this;}
				
				public BurgerBuilder setCheese(boolean cheese) {
					this.cheese = cheese;
					return this;}
				
				public BurgerBuilder setTomatoe(boolean tomatoe) {
					this.tomato = tomatoe;
					return this;}
				
				public BurgerBuilder setLettuce(boolean lettuce) {
					this.lettuce = lettuce;
					return this;}
				
				public BurgerBuilder setCatsup(boolean catsup) {
					this.ketchup = catsup;
					return this;}
				
				public BurgerBuilder setMayonnaise(boolean mayonnaise) {
					this.mayonnaise = mayonnaise;
					return this;}
				
				public BurgerBuilder setMustard(boolean mustard) {
					this.mustard = mustard;
					return this;}
				
				public BurgerBuilder setNotes(String notes) {
					this.notes = notes;
					return this;}
				
				
				public CustomBurger build() {
					return new CustomBurger(bread, patty,  numberOfPatties, cheese,  tomato,  lettuce,
							 ketchup, mayonnaise,  mustard,  notes);
				}
	
				
	
	}
}
