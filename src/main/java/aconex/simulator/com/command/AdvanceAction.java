package aconex.simulator.com.command;

import aconex.simulator.com.Field;
import aconex.simulator.com.model.Bulldozer;
import aconex.simulator.com.model.Item;
import aconex.simulator.com.model.Land;
import aconex.simulator.com.model.Report;

public class AdvanceAction implements BulldozerAction {

	private int moves;
	
	public AdvanceAction(int moves) {
		this.moves = moves;
	}
	
	/**
	 * Moves bulldozer depending on moves and direction.
	 */
	@Override
	public boolean execute(Bulldozer bulldozer, Field field) {
		Report.updateReport(Item.COMMUNICATON,1);
		int fieldSizeX = field.getFieldTiles()[0].length;
		int fieldSizeY = field.getFieldTiles().length;
		if(!validateMove(bulldozer, fieldSizeX, fieldSizeY)) {
			return false;
		}
		
		return visitEachLand(bulldozer, field);
	}
	
	/**
	 * Validates if the bulldozer does not go outside the field
	 * 
	 * @param bulldozer
	 * @param fieldSizeX
	 * @param fieldSizeY
	 * @return
	 */
	private boolean validateMove(Bulldozer bulldozer, int fieldSizeX, int fieldSizeY) {
		switch(bulldozer.getOrientation()) {
		case LEFT:
			return check(bulldozer.getPositionX()-moves, bulldozer.getPositionY(), fieldSizeX, fieldSizeY);
		case UP:
			return check(bulldozer.getPositionX(), bulldozer.getPositionY()-moves, fieldSizeX, fieldSizeY);
		case RIGHT:
			return check(bulldozer.getPositionX()+moves, bulldozer.getPositionY(), fieldSizeX, fieldSizeY);
		case DOWN:
			return check(bulldozer.getPositionX(), bulldozer.getPositionY()+moves, fieldSizeX, fieldSizeY);
		}
		return false;
	}
	
	private boolean check(int x, int y, int fieldSizeX, int fieldSizeY) {
		return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
	}
	
	/**
	 * Visit each land to clear them. It calls the clear implementation depending on the land
	 * @param bulldozer
	 * @param field
	 * @return
	 */
	private boolean visitEachLand(Bulldozer bulldozer, Field field) {
		int positionX = bulldozer.getPositionX();
		int positionY = bulldozer.getPositionY();
		for(int i=1; i<=moves; i++) {
			Land land = null;;
			switch(bulldozer.getOrientation()) {
			case LEFT:
				positionX -= 1;
				break;
			case UP:
				positionY -= 1;
				break;
			case RIGHT:
				positionX += 1;
				break;
			case DOWN:
				positionY += 1;
				break;
			}
			land = field.getFieldTiles()[positionY][positionX];
		    land.clear(i==moves);
		    boolean destroy = Report.getReportMap().get(Item.DESTROY)==1;
		    if (destroy) {
		    	return false;
		    }
		}
		bulldozer.setPositionX(positionX);
		bulldozer.setPositionY(positionY);
		return true;
	}
	
	@Override
    public String toString() {
    	return "advance " + moves;
    }

}
