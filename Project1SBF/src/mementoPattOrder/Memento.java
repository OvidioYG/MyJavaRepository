package mementoPattOrder;


import java.util.ArrayList;
import java.util.List;
import service.Meal;

// we save the current state of List<meals> from Order
//a new Memento object is created from any type of manipulation method from order

public class Memento {
	
	private final List<Meal> state;
	
	
	public Memento(List<Meal> state) {
		this.state= new ArrayList<>(state);
		
	}

	public List<Meal> getState() {
		return this.state;
	}
	
	

		
	
}
