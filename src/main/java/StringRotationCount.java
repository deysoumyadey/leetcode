import java.util.logging.Level;
import java.util.logging.Logger;

public class StringRotationCount {
	private final static Logger LOGGER =  Logger.getLogger(StringRotationCount.class.getName());
	public static int shiftedDiff(String first, String second) {
		int firstLength = first.length();
		String concatenatedStr;
		LOGGER.log(Level.INFO, String.format("Starting the loop for clockwise shift for input: %s and %s", first, second));
		for(int i=0; i<firstLength; i++) {
			if(i!=0)
				concatenatedStr = first.substring(firstLength-i)+first.substring(0, firstLength-i);
			else
				concatenatedStr = first;
			LOGGER.log(Level.FINE, String.format("Concatenated String: %s", concatenatedStr));
			if(concatenatedStr.equals(second)) {
				LOGGER.log(Level.INFO, String.format("Found the number of rotation of %s to %s", first, second));
				return i;
			}
		}	
		LOGGER.log(Level.INFO, String.format("Second string: %s is not valid rotaion for first String: %s", second, first));
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(shiftedDiff("coffee", "eecoff"));
		System.out.println(shiftedDiff("eecoff", "coffee"));
		System.out.println(shiftedDiff("Moose", "moose"));
		System.out.println(shiftedDiff("isn't", "'tisn"));
		System.out.println(shiftedDiff("Esham", "Esham"));
		System.out.println(shiftedDiff("Esham", "mEsha"));
		System.out.println(shiftedDiff("dog", "god"));
		
	}
}

