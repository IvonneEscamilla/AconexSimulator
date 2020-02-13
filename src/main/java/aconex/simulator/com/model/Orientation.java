package aconex.simulator.com.model;

public enum Orientation {
	RIGHT('r'){
		public String toString() {
			return "East";
		}
	},
	LEFT('l'){
		public String toString() {
			return "West";
		}
	},
	DOWN('d'){
		public String toString() {
			return "South";
		}
	},
	UP('u'){
		public String toString() {
			return "North";
		}
	};
	
	private char value;
	
	private Orientation(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
	
}
