package aconex.simulator.com.provider;

import aconex.simulator.com.Field;
import aconex.simulator.com.exception.FieldCreateException;
import aconex.simulator.com.model.LandFactory;

public abstract class FieldProvider {
	
	protected LandFactory landFactory;
	
	public FieldProvider(LandFactory landFactory) {
		this.landFactory = landFactory;
	}
	
	public abstract Field createField() throws FieldCreateException;

}
