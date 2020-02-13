package aconex.simulator.com.model;

public class TreeLand extends Land {

	public TreeLand(int fuelClearCost, int fuelClearedCost) {
		super(fuelClearCost, fuelClearedCost);
	}
	
	@Override
	public void clear(boolean stop) {
		if(!visited) {
			visited = true;
			Report.updateReport(Item.UNCLEAR,1);
			Report.updateReport(Item.FUEL, fuelClearCost);
			if(!stop) {
				Report.updateReport(Item.REPAIR, 1);
			}
		} else {
			Report.updateReport(Item.FUEL, fuelClearedCost);
		}
	}
	
	@Override
	public String toString() {
		return "t";
	}
}
