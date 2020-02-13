package aconex.simulator.com.model;

public class Bulldozer {

	private int positionX;
	private int positionY;
	private Orientation orientation;
	
	/**
	 * Bulldoze object constructor
	 * 
	 * @param positionX
	 * @param positionY
	 * @param orientation
	 */
	public Bulldozer(int positionX, int positionY, Orientation orientation) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
