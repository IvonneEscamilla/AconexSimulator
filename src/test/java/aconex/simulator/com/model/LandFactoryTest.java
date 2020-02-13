package aconex.simulator.com.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LandFactoryTest {
	
	@Test
	public void createLandPlain() {
		LandFactory factory = new LandFactory();
		Land land = factory.createLand('o');
		assertTrue(land instanceof PlainLand);
	}
}
