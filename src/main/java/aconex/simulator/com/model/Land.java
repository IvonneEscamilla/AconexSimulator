package aconex.simulator.com.model;

public abstract class Land {
	protected boolean visited;
	protected int fuelClearCost;
	protected int fuelClearedCost;
	
	public Land(int fuelClearCost, int fuelClearedCost) {
		this.fuelClearCost = fuelClearCost;
		this.fuelClearedCost = fuelClearedCost;
	}
	
	public Land() {
		
	}
	
	public void clear(boolean stop) {
		if(!visited) {
			visited = true;
			Report.updateReport(Item.UNCLEAR,1);
			Report.updateReport(Item.FUEL, fuelClearCost);
		} else {
			Report.updateReport(Item.FUEL, fuelClearedCost);
		}
	}
	
	public int getFuelClearCost() {
		return fuelClearCost;
	}
	public void setFuelClearCost(int fuelClearCost) {
		this.fuelClearCost = fuelClearCost;
	}
	public int getFuelClearedCost() {
		return fuelClearedCost;
	}
	public void setFuelClearedCost(int fuelClearedCost) {
		this.fuelClearedCost = fuelClearedCost;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
