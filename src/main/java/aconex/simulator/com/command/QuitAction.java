package aconex.simulator.com.command;

import aconex.simulator.com.Field;
import aconex.simulator.com.model.Bulldozer;

public class QuitAction implements BulldozerAction {

	/**
	 * Return false indicating the command should terminate de application
	 */
	@Override
	public boolean execute(Bulldozer bulldozer, Field field) {
		return false;
	}
	
	@Override
    public String toString() {
    	return "quit";
    }

}
