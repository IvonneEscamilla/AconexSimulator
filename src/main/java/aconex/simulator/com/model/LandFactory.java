package aconex.simulator.com.model;

public class LandFactory {
	
	public Land createLand(char landType) {
		Land land;
		int fuel = 1;
		switch (landType) {
		case 'o':
			land = new PlainLand(fuel, fuel);
			break;
		case 'r':
			land = new RockyLand(fuel*2, fuel);
			break;
		case 't':
			land = new TreeLand(fuel*2, fuel);
			break;
		case 'T':
			land = new ProtectedLand();
			break;
		default:
			throw new IllegalArgumentException(
					String.format("File contains invalid character %s ", landType));
		}
		return land;
	}

}
