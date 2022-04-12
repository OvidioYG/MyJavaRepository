package meal.items.interfaces;

public abstract class Burger extends Food{
	
	private String  bread;
	private String  patty;
	private boolean cheese;
	
	
	
	public Burger(String bread, String patty, boolean cheese) {
		
		this.bread = bread;
		this.patty = patty;
		this.cheese = cheese;
	}
	
	
	public String getBread() {
		return this.bread;}
	
	public String getPatty() {
		return this.patty;}
	
	
	public boolean isCheese() {
		return this.cheese;}
	
	
}
