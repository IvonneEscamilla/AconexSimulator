package aconex.simulator.com.command;

import aconex.simulator.com.Field;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.Item;
import aconex.simulator.com.model.Orientation;
import aconex.simulator.com.model.Report;

public class RightAction implements BulldozerAction{

	/**
	 * Change bulldozer direction to the Right depending on current orientation
	 */
	@Override
	public boolean execute(Bulldozer bulldozer, Field field) {
		Orientation orientation = bulldozer.getOrientation();
		switch(orientation) {
		case UP:
			bulldozer.setOrientation(Orientation.RIGHT);
			break;
		case RIGHT:
			bulldozer.setOrientation(Orientation.DOWN);
			break;
		case DOWN:
			bulldozer.setOrientation(Orientation.LEFT);
			break;
		case LEFT:
			bulldozer.setOrientation(Orientation.UP);
			break;
		}
		Report.updateReport(Item.COMMUNICATON, 1);
		return true;
	}

	@Override
    public String toString() {
    	return "turn right";
    }
}
