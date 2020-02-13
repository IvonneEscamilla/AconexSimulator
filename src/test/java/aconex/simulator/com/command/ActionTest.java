package aconex.simulator.com.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import aconex.simulator.com.Field;
import aconex.simulator.com.exception.FieldCreateException;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.Item;
import aconex.simulator.com.model.LandFactory;
import aconex.simulator.com.model.Orientation;
import aconex.simulator.com.model.Report;
import aconex.simulator.com.provider.FieldProvider;
import aconex.simulator.com.provider.FileFieldProvider;

public class ActionTest {

	Bulldozer bulldozer;
	
	@Test
	public void executeLeftTest() {
		bulldozer = new Bulldozer(-1, -1, Orientation.RIGHT);
		BulldozerAction action = new LeftAction();
		Report.initializeReport(20);
		action.execute(bulldozer, null);
		assertEquals(Orientation.UP, bulldozer.getOrientation());
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
	}
	
	@Test
	public void executeRightTest() {
		bulldozer = new Bulldozer(-1, -1, Orientation.RIGHT);
		BulldozerAction action = new RightAction();
		Report.initializeReport(20);
		action.execute(bulldozer, null);
		assertEquals(Orientation.DOWN, bulldozer.getOrientation());
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
	}
	
	@Test
	public void advanceTestOutside() throws FieldCreateException {
		bulldozer = new Bulldozer(9, 4, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(4);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		boolean result = action.execute(bulldozer, res);
		assertFalse(result);
	}
	
	@Test
	public void advanceTestOutsideInitialLeft() throws FieldCreateException {
		bulldozer = new Bulldozer(-1, 0, Orientation.DOWN);
		BulldozerAction action = new AdvanceAction(4);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		boolean result = action.execute(bulldozer, res);
		assertFalse(result);
	}
	
	@Test
	public void advanceTestOutsideInitialRight() throws FieldCreateException {
		bulldozer = new Bulldozer(10, 0, Orientation.DOWN);
		BulldozerAction action = new AdvanceAction(4);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		boolean result = action.execute(bulldozer, res);
		assertFalse(result);
	}
	
	@Test
	public void advanceTestToPlain() throws FieldCreateException {
		bulldozer = new Bulldozer(-1, 0, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(1);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		action.execute(bulldozer, res);
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
		assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void advanceTestToRocky() throws FieldCreateException {
		bulldozer = new Bulldozer(1, 2, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(1);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		action.execute(bulldozer, res);
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void advanceTestToTreeStop() throws FieldCreateException {
		bulldozer = new Bulldozer(1, 0, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(1);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		action.execute(bulldozer, res);
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(0, Report.getReportMap().get(Item.REPAIR).intValue());
		assertEquals(0, Report.getReportMap().get(Item.DESTROY).intValue());
	}
	
	@Test
	public void advanceTestToTreeNoStop() throws FieldCreateException {
		bulldozer = new Bulldozer(1, 0, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(2);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		action.execute(bulldozer, res);
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
		assertEquals(3, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(18, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(1, Report.getReportMap().get(Item.REPAIR).intValue());
		assertEquals(0, Report.getReportMap().get(Item.DESTROY).intValue());
	}
	
	@Test
	public void advanceTestToProtected() throws FieldCreateException {
		bulldozer = new Bulldozer(5, 1, Orientation.RIGHT);
		BulldozerAction action = new AdvanceAction(3);
		Report.initializeReport(20);
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, new LandFactory());
		Field res = field.createField();
		action.execute(bulldozer, res);
		assertEquals(1, Report.getReportMap().get(Item.COMMUNICATON).intValue());
		assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(1, Report.getReportMap().get(Item.DESTROY).intValue());
		assertEquals(0, Report.getReportMap().get(Item.REPAIR).intValue());
	}	
	
}
