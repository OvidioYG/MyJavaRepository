package meal.items;

import java.util.ArrayList;
import java.util.List;

import meal.items.interfaces.Food;


public class HotDog extends Food{
	
	private List<String> toppings= new ArrayList<String>();
	private char size;
	
	private HotDog(List<String> toppings, char size) {
		this.toppings=toppings;
		this.size=size;
		
	}
	
	public char getSize() {
		return this.size;
	}
	
	public List<String> gettoppings() {
		return this.toppings;
	}
	
	
	
	@Override
	public String toString() {
		
		StringBuilder topps=new StringBuilder();
		
		for(String a: toppings) {
			topps.append("\n"+ "    -  "+ a );
			
		}
		
		if(topps.isEmpty())
			topps.append(" *No toppings*");
		
		
		return "  HotDog:" + "\n" 
				+ "------------------------------" +"\n"
	            + " size : " + size + "\n"
			    + " toppings: " + "\n" 
	            +   topps + "\n";
				
		
	}



	public static class HotDogBuilder {
		
		private List<String> toppings= new ArrayList<String>();
		private char size='N'; //can only edit size to N or L (Normal, Large)
		
		
		
		public HotDogBuilder setTopping(String topping) {
			this.toppings.add(topping);
			return this;}


		public HotDogBuilder setSize(char size) {
			
			
			
			try {
				if(size == 'N' || size == 'L') {
					this.size = size;
					
				    }
				else {
					throw new Exception();
				}
				
			}catch(Exception e){
				System.out.println("    Invalid size for the hotDog " + "\n" 
						+ "    Available sizes for a HotDog are 'N' (normal size) and 'L' (Large size)" + "\n"
						+ "    The default size of 'N' was used" +"\n");
				this.size = 'N';
			}
			
			
			return this;
			
		}


		public HotDog build() {
			return new HotDog(toppings,size);
		}
		
	
	}
	
}
