package aconex.simulator.com.model;

import java.util.HashMap;
import java.util.Map;

public class Report {

	private static Map<Item, Integer> reportMap;
	
	public static void updateReport(Item item, int amount) {
		Integer total = reportMap.get(item);
		switch(item) {
		case UNCLEAR:
			reportMap.put(item, total-amount);
			break;
		case FUEL:
		case COMMUNICATON:
		case DESTROY:
		case REPAIR:
			reportMap.put(item, total==null?amount:total+amount);
			break;
		}		
	}
	
	public static void initializeReport(int size) {
		reportMap = new HashMap<>();
		reportMap.put(Item.COMMUNICATON, 0);
		reportMap.put(Item.FUEL, 0);
		reportMap.put(Item.UNCLEAR, size);
		reportMap.put(Item.DESTROY, 0);
		reportMap.put(Item.REPAIR, 0);
	}
	
	public static Map<Item, Integer> getReportMap(){
		return reportMap;
	}

}
