package aconex.simulator.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aconex.simulator.com.command.AdvanceAction;
import aconex.simulator.com.command.BulldozerAction;
import aconex.simulator.com.command.LeftAction;
import aconex.simulator.com.command.QuitAction;
import aconex.simulator.com.command.RightAction;
import aconex.simulator.com.exception.FieldCreateException;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.LandFactory;
import aconex.simulator.com.model.Orientation;
import aconex.simulator.com.model.Report;
import aconex.simulator.com.provider.FieldProvider;
import aconex.simulator.com.provider.FileFieldProvider;
import aconex.simulator.com.util.PrintConsoleReport;
import aconex.simulator.com.util.PrintReport;

public class App 
{
	private static final Scanner scanner = new Scanner(System.in);
	private static List<BulldozerAction> actions = new ArrayList<>();
	private static PrintReport printReport = new PrintConsoleReport();
	
    public static void main( String[] args )
    {
    	System.out.print("File Location> ");
        String fileName = scanner.next();
        LandFactory factory = new LandFactory();
        FieldProvider fieldP = new FileFieldProvider(fileName, factory);
        Field field = null;
        Bulldozer bulldozer = null;
        boolean runSimulator = true;
        try {
			field = fieldP.createField();
			bulldozer = new Bulldozer(-1, 0, Orientation.RIGHT);
	        printReport.printStartup(field, bulldozer);
	        Report.initializeReport(field.getUnlearFields());
		} catch (FieldCreateException e) {
			System.out.println("There was an error processing the file");
			runSimulator = false;
		}
         
        while (runSimulator) {
        	System.out.print("(l)eft, (r)ight, (a)dvance <n>, (q)uit: ");
        	String command = scanner.next();
        	BulldozerAction action = null;
        	switch(command.charAt(0)) {
        	case 'a':
        		int moves = scanner.nextInt();
        		action = new AdvanceAction(moves);
        		break;
        	case 'l':
        		action = new LeftAction();
        		break;
        	case 'r':
        		action = new RightAction();
        		break;
        	case 'q':
        		action = new QuitAction();
        		runSimulator = false;
        		break;
        	default:
        		System.out.println("Invalid command");
        		break;
        	}
        	
        	if(action!=null) {
        		runSimulator =action.execute(bulldozer, field);
        		actions.add(action);	
        	}
        }
        if(actions.size()>0) {
        	printReport.printCommands(actions);
        	printReport.printReport();
        }
        
    }
    
}
