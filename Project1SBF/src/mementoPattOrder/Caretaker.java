package mementoPattOrder;


import java.util.ArrayList;
import java.util.List;

import service.Meal;


public class Caretaker {
	
	private List<Memento> stateList= new ArrayList<>();

	public void push(Memento state) { //used to add a new state
		stateList.add(state);
		
		if(stateList.size()==5) {
			stateList.remove(0);
		}
		
	}
	
	public List<Meal> pop() { //used to return the previous state
		
		var LastState= stateList.get(stateList.size()-1);
		stateList.remove(LastState);
		
		
		return stateList.get(stateList.size()-1).getState();
		
		
		
	}
	
	
	
	

}
