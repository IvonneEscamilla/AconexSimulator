package aconex.simulator.com.util;

import java.util.List;

import aconex.simulator.com.Field;
import aconex.simulator.com.command.BulldozerAction;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.Item;
import aconex.simulator.com.model.Land;
import aconex.simulator.com.model.Report;

public class PrintConsoleReport implements PrintReport {

	/**
	 * Prints the welcome message and the initial field
	 */
	@Override
	public void printStartup(Field field, Bulldozer bulldozer) {
		System.out.println("Welcome to the Aconex site clearing simulator. This is a map of the site:");
		Land[][] land = field.getFieldTiles();
		for(int i = 0; i< land.length; i++) {
			for(int j=0; j<land[0].length; j++) {
				System.out.print(land[i][j].toString());
			}
			System.out.println();
		}
		String bulldozerPosY = null;
		if(bulldozer.getPositionY()==0) {
			bulldozerPosY = "Northern edge";
		}
		else if (bulldozer.getPositionY() == land.length){
			bulldozerPosY = "Southern edge";
		} else {
			bulldozerPosY = "Middle";
		}
		String bulldozerPosX = null;
		if(bulldozer.getPositionX()<land[0].length/2) {
			bulldozerPosX = "West";
		} else {
			bulldozerPosX = "East";
		}
		System.out.println("The bulldozer is currently located  at the " + bulldozerPosY + " of the site, immediately to the " + bulldozerPosX 
				+ " of the site, and facing " + bulldozer.getOrientation().toString());
		System.out.println();
	}

	/**
	 * Prints all commands inserted by the user
	 */
	@Override
	public void printCommands(List<BulldozerAction> actions) {
		System.out.println("The simulation has ended. These are the commands you issue");
		System.out.println();
		System.out.print(actions.remove(0).toString());
		for(BulldozerAction a : actions) {
    		System.out.print(", " + a.toString() );
    	}
    	System.out.println();
    	System.out.println();
	}

	/**
	 * Prints the table with details and cost for each action
	 */
	@Override
	public void printReport() {
		int total = 0;
		System.out.println("The cost of this land clearing operation were: ");
		String leftAlignFormat = " %-30s %-9s %-5s";
		System.out.format(leftAlignFormat, "Item", "Quantity", "Cost");
		System.out.println();
		total = printItem(Item.COMMUNICATON, leftAlignFormat, total);
		total = printItem(Item.FUEL, leftAlignFormat, total);
		total = printItem(Item.UNCLEAR, leftAlignFormat, total);
		total = printItem(Item.DESTROY, leftAlignFormat, total);
		total = printItem(Item.REPAIR, leftAlignFormat, total);
		System.out.println("----");
		System.out.format(leftAlignFormat, "Total", " ", total);
		System.out.println();
		System.out.println();
		System.out.println("Thankyou for using the Aconex site clearing simulator.");
	}
	
	private int printItem(Item item, String leftAlignFormat, int total) {
		int count =  Report.getReportMap().get(item);
		int cost = count * item.getCost();
		total += cost;
		System.out.format(leftAlignFormat, item.toString(), count , cost);
		System.out.println();
		return total;
	}

}
