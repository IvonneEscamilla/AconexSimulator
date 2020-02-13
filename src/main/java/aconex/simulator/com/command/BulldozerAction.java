package aconex.simulator.com.command;

import aconex.simulator.com.Field;
import aconex.simulator.com.model.Bulldozer;

public interface BulldozerAction {

	public boolean execute(Bulldozer bulldozer, Field field);
}
