import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * 
 * @author soumya
 * Given a descending list of values, 
 * sum the digits of each value to create a new value and 
 * return the list of new values ordered from lowest to highest.
 * You are provided a string containing a list of positive integers separated by a space (" "). Take each value and calculate the sum of its digits, which we call it's "weight". Then return the list in ascending order by weight, as a string joined by a space.

For example 99 will have "weight" 18, 100 will have "weight"
1 so in the ouput 100 will come before 99.

Example:

"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
"100 180 90 56 65 74 68 86 99"

When two numbers have the same "weight", let's consider them to be strings and not numbers:

100 is before 180 because its "weight" (1) is less than the one of 180 (9)
and 180 is before 90 since, having the same "weight" (9) it comes before as a string.

All numbers in the list are positive integers and the list can be empty.
 */

public class OrderWeight {
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static String orderWeight(String inputStr) {
		Map<Integer, ArrayList<String>> weightMap = new HashMap<>();
		LOGGER.log(Level.INFO, String.format("Starting the loop for ordering weight for input: %s", inputStr));
		for(String numStr: inputStr.split(" ")) {
			int individualSum=0;
			for(char c: numStr.toCharArray()) {
				if(Character.isDigit(c)) {
					individualSum += Integer.parseInt(String.valueOf(c));
				} else {
					throw new RuntimeException("Invalid character amongst the in put String");
				}
			}
			LOGGER.log(Level.FINE, String.format("Inserting string %s of sum %s in the map", numStr, individualSum));
			insertValue(weightMap, individualSum, numStr);
		}
		LOGGER.log(Level.INFO, String.format("End of loop for ordering weight for input: %s", inputStr));
		return weightMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.map(Map.Entry::getValue)
				.flatMap(List::stream)
				.collect(Collectors.joining(" "));
	}
	private static Map<Integer, ArrayList<String>> insertValue(Map<Integer, ArrayList<String>> weightMap, int sumKey, String numStrVal){
		ArrayList<String> strListVal = null;
		if(weightMap.containsKey(sumKey)) {
			strListVal = weightMap.get(sumKey);
			if(strListVal == null) {
				strListVal = new ArrayList<>();
			}
			strListVal.add(numStrVal);
			strListVal.sort(null);
		} else {
			strListVal = new ArrayList<>();
			strListVal.add(numStrVal);
		}
		weightMap.put(sumKey, strListVal);
		return weightMap;
	}
    
	public static void main(String[] args) {
		System.out.println("****** Basic Tests ******");
		//assertEquals("2000 103 123 4444 99", 
		System.out.println(OrderWeight.orderWeight("103 123 4444 99 2000"));
		//assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", 
		System.out.println(OrderWeight.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}
}

