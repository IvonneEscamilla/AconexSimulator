package aconex.simulator.com.command;

import aconex.simulator.com.Field;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.Item;
import aconex.simulator.com.model.Orientation;
import aconex.simulator.com.model.Report;

public class LeftAction implements BulldozerAction {

	/**
	 * Change bulldozer direction to the Left depending on current orientation
	 */
	@Override
	public boolean execute(Bulldozer bulldozer, Field field) {
		Orientation orientation = bulldozer.getOrientation();
		switch(orientation) {
		case UP:
			bulldozer.setOrientation(Orientation.LEFT);
			break;
		case RIGHT:
			bulldozer.setOrientation(Orientation.UP);
			break;
		case DOWN:
			bulldozer.setOrientation(Orientation.RIGHT);
			break;
		case LEFT:
			bulldozer.setOrientation(Orientation.DOWN);
			break;
		}	
	    Report.updateReport(Item.COMMUNICATON,1);
	    return true;
	}

    @Override
    public String toString() {
    	return "turn left";
    }
}
