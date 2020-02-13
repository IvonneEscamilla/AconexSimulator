package aconex.simulator.com.util;

import java.util.List;

import aconex.simulator.com.Field;
import aconex.simulator.com.command.BulldozerAction;
import aconex.simulator.com.model.Bulldozer;

public interface PrintReport {

	public void printStartup(Field field, Bulldozer bulldozer);
	public void printCommands(List<BulldozerAction> actions);
	public void printReport();
	
}
