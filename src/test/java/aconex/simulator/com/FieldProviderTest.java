package aconex.simulator.com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aconex.simulator.com.exception.FieldCreateException;
import aconex.simulator.com.model.LandFactory;
import aconex.simulator.com.model.PlainLand;
import aconex.simulator.com.provider.FieldProvider;
import aconex.simulator.com.provider.FileFieldProvider;

public class FieldProviderTest {
	
	private LandFactory factory = new LandFactory();
	
	@Test(expected = FieldCreateException.class)
	public void createFieldFileException() throws FieldCreateException {
		String fileName = "fieldFile.txt";
		FieldProvider field = new FileFieldProvider(fileName, factory);
		field.createField();
	}
	
	@Test
	public void createFieldFillDetails() throws FieldCreateException{
		String fileName = "field.txt"; 
		FieldProvider field = new FileFieldProvider(fileName, factory);
		Field res = field.createField();
		assertNotNull("Field is not created", res.getFieldTiles());
		assertTrue(res.getFieldTiles()[0][0] instanceof PlainLand);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createFieldInvalidChar() throws FieldCreateException{
		String fileName = "fieldInvalid.txt";
		FieldProvider field = new FileFieldProvider(fileName, factory);
		field.createField();
	}
	

}
