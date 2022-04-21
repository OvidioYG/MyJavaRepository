package meal.items;

import meal.items.interfaces.Burger;

//Builder
public class CustomBurger extends Burger {
	
	
	private int     numberOfPatties;
	private boolean tomatoe, lettuce;
	private boolean catsup, mayonnaise, mustard;
	private String  notes;
	
	private CustomBurger(String bread, String patty, int numberOfPatties, boolean cheese, boolean tomatoe, boolean lettuce,
			boolean catsup, boolean mayonnaise, boolean mustard, String notes) {
		
		super(bread,patty,cheese);
		this.numberOfPatties = numberOfPatties;
		this.tomatoe = tomatoe;
		this.lettuce = lettuce;
		this.catsup = catsup;
		this.mayonnaise = mayonnaise;
		this.mustard = mustard;
		this.notes = notes;
	}
	
	
	// we only need patties getter function for price calculation, but for bill we need all the attributes
	
			public int getNumberOfPatties() {
				return numberOfPatties;}
		
		
			public boolean isTomatoe() {
				return tomatoe;}
		
		
			public boolean isLettuce() {
				return lettuce;}
		
		
			public boolean isCatsup() {
				return catsup;}
		
		
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
						+ " tomatoe    : " + (tomatoe? "with tomatoe":"no tomatoe") + "\n"
						+ " lettuce    : " + (lettuce? "with lettuce":"no lettuce") + "\n"
						+ " ketchup    : " + (catsup? "with ketchup":"no Ketchup") + "\n"
						+ " mayonnaise : " + (mayonnaise? "with mayonnaise":"no mayonnaise") + "\n"
						+ " mustard    : " + (mustard? "with mustard":"no mustard")+ "\n"
						+ " notes      : " + (notes.isBlank()? "-No notes-":notes );
			}
			
			
			
			public static class BurgerBuilder {
				
				private String  bread = "Burger Bun";
				private String  patty = "Beef";
				private int     numberOfPatties = 1;
				private boolean cheese  = true;
				private boolean tomatoe = true, lettuce  = true;
				private boolean catsup  = true, mayonnaise = true, mustard = true;
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
					this.tomatoe = tomatoe;
					return this;}
				
				public BurgerBuilder setLettuce(boolean lettuce) {
					this.lettuce = lettuce;
					return this;}
				
				public BurgerBuilder setCatsup(boolean catsup) {
					this.catsup = catsup;
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
					return new CustomBurger(bread, patty,  numberOfPatties, cheese,  tomatoe,  lettuce,
							 catsup, mayonnaise,  mustard,  notes);
				}
	
				
	
	}
}
