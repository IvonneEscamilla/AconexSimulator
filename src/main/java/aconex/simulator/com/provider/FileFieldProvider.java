package aconex.simulator.com.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import aconex.simulator.com.Field;
import aconex.simulator.com.exception.FieldCreateException;
import aconex.simulator.com.model.Land;
import aconex.simulator.com.model.LandFactory;
import aconex.simulator.com.model.ProtectedLand;

public class FileFieldProvider extends FieldProvider {

	private String fileName;
	private int unclearFields;
	
	public FileFieldProvider(String fileName, LandFactory landFactory) {
		super(landFactory);
		this.fileName = fileName;
	}
	
	/**
	 * Return a Field object with the information sent in a file
	 */
	@Override
	public Field createField() throws FieldCreateException {
		List<String> fieldDetails = new ArrayList<>();
		Field field = new Field();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			fieldDetails = br.lines().collect(Collectors.toList());
		} catch (IOException|NullPointerException ioe) {
			throw new FieldCreateException("Failed reading file");
		}

		if (!fieldDetails.isEmpty()) {
			Land[][] lands = processFieldDetails(fieldDetails);
			field.setFieldTiles(lands);
			field.setUnclearFields(unclearFields);
			return field;
		}
		throw new FieldCreateException("Failed creating field");
	}
	
	/**
	 * Filled the field with Land objects depending on the fieldDetails
	 * @param fieldDetails
	 * @return
	 */
	private Land[][] processFieldDetails(List<String> fieldDetails){
		Land[][] fieldTiles = new Land[fieldDetails.size()][fieldDetails.get(0).length()];
		for (int row = 0; row<fieldDetails.size(); row++) {
			for(int column = 0; column<fieldDetails.get(row).length(); column++) {
				char typeLand = fieldDetails.get(row).charAt(column);
				Land land = landFactory.createLand(typeLand);
				if(!(land instanceof ProtectedLand)) {
					unclearFields++;
				}
				fieldTiles[row][column] = land;
			}
		}
		return fieldTiles;
	}

}
