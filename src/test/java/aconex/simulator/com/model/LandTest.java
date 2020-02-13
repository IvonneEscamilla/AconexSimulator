package aconex.simulator.com.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LandTest {

	@Test
	public void visitPlainTest() {
		Land plainLand = new PlainLand(1,1);
		Report.initializeReport(20);
		plainLand.clear(false);
		assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void visitPlainTwiceTest() {
		Land plainLand = new PlainLand(1,1);
		Report.initializeReport(20);
		plainLand.clear(false);
		assertEquals(1, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		plainLand.clear(false);
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void visitRockyTest() {
		Land rockyLand = new RockyLand(2, 1);
		Report.initializeReport(20);
		rockyLand.clear(false);
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void visitRockyTwiceTest() {
		Land rockyLand = new RockyLand(2, 1);
		Report.initializeReport(20);
		rockyLand.clear(false);
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		rockyLand.clear(false);
		assertEquals(3, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
	}
	
	@Test
	public void visitTreeStopTest() {
		Land treeLand = new TreeLand(2, 1);
		Report.initializeReport(20);
		treeLand.clear(true);
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(0, Report.getReportMap().get(Item.REPAIR).intValue());
	}
	
	@Test
	public void visitTreeNoStopTest() {
		Land treeLand = new TreeLand(2, 1);
		Report.initializeReport(20);
		treeLand.clear(false);
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(1, Report.getReportMap().get(Item.REPAIR).intValue());
	}
	
	@Test
	public void visitTreeTwiceTest() {
		Land treeLand = new TreeLand(2, 1);
		Report.initializeReport(20);
		treeLand.clear(false);
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(2, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(1, Report.getReportMap().get(Item.REPAIR).intValue());
		treeLand.clear(false);
		assertEquals(19, Report.getReportMap().get(Item.UNCLEAR).intValue());
		assertEquals(3, Report.getReportMap().get(Item.FUEL).intValue());
		assertEquals(1, Report.getReportMap().get(Item.REPAIR).intValue());
	}
	
	@Test
	public void visitProtectedTest() {
		Land protectedLand = new ProtectedLand();
		protectedLand.clear(false);
		assertEquals(1, Report.getReportMap().get(Item.DESTROY).intValue());
	}
}
