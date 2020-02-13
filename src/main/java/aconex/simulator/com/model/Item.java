package aconex.simulator.com.model;

public enum Item {
	COMMUNICATON(1){
        public String toString() {
            return "Communication overhead";
        }
    },
	FUEL(1){
        public String toString() {
            return "Fuel usage";
        }
    },
	UNCLEAR(3){
        public String toString() {
            return "Unclear squares";
        }
    },
	DESTROY(10){
        public String toString() {
            return "Destruction of protected tree";
        }
    },
	REPAIR(2){
        public String toString() {
            return "Paint damage to bulldozer";
        }
    };

	private final int cost;
	
	private Item(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}
}
