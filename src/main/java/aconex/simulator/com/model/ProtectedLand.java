package aconex.simulator.com.model;

public class ProtectedLand extends Land {

	public ProtectedLand() {
	}
	
	@Override
	public void clear(boolean stop) {
		Report.updateReport(Item.DESTROY,1);
	}
	
	@Override
	public String toString() {
		return "T";
	}
}
