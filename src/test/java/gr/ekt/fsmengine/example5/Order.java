package gr.ekt.fsmengine.example5;

import gr.ekt.fsmengine.api.StateContext;

/**
 * Represents an order.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class Order implements StateContext  {

	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The amount.
	 */
	private double amount;
	
	/**
	 * The current state.
	 */
	private String currentState;
	
	/**
	 * Constructor.
	 */
	public Order() {
		currentState = "STATE_ORD";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStateName() {
		return currentState;
	}

	public void setStateName(String stateName) {
		currentState = stateName;
	}

	public boolean isDone() {
		return "STATE_SHIPPED".equals(currentState);
	}

	public StateContext getParent() {
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("[Order name=%s, amount=%.2f, state=%s, done=%b]", name, amount, currentState, isDone());
	}

}
