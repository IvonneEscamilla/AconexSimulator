package aconex.simulator.com;

import aconex.simulator.com.model.Land;

public class Field {

	private Land[][] fieldTiles;
	private int unclearFields;
	
	public int getUnlearFields() {
		return unclearFields;
	}

	public void setUnclearFields(int clearFields) {
		this.unclearFields = clearFields;
	}
	
	public Land[][] getFieldTiles() {
		return fieldTiles;
	}

	public void setFieldTiles(Land[][] fieldTiles) {
		this.fieldTiles = fieldTiles;
	}
}
