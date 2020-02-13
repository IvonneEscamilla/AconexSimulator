package aconex.simulator.com.model;

public class PlainLand extends Land {
	
	public PlainLand(int fuelClearCost, int fuelClearedCost) {
		super(fuelClearCost, fuelClearedCost);
	}
	
	@Override
	public String toString() {
		return "o";
	}

}
