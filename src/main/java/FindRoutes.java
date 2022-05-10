import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/***
 * 
 * @author soumya Task We are tracking down our rogue agent and she travels from
 *         place to place to avoid being tracked. Each of her travels are based
 *         on a list of itineraries in an unusual or incorrect order. The task
 *         is to determine the complete route she will take.
 * 
 *         You are given an array of routes containing her travel itineraries.
 *         Convert this into a complete, in-order list of the places she will
 *         travel.
 * 
 *         Specification Challenge.findRoutes(routes) Parameters routes:
 *         List<String[]> - Array of itineraries
 * 
 *         Return Value String - An ordered list or destinations
 * 
 *         Constraints All inputs have at least one valid, complete route
 * 
 *         Examples routes Return Value
 *         [["USA","BRA"],["JPN","PHL"],["BRA","UAE"],["UAE","JPN"]]
 *         
 *         "USA, BRA, UAE, JPN, PHL"
 */

class Node {
    String leftVal;
    String rightVal;
    Node left;
    Node right;

    Node(String leftVal, String rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        right = null;
        left = null;
    }
}

public class FindRoutes {
	
	private static Node addToNode(Node current, String leftVal, String rightVal) {
	    if (current == null) {
	        return new Node(leftVal, rightVal);
	    }
	    if (leftVal == current.rightVal) {
	    	current.right = new Node(leftVal, rightVal);
	    }
	    if (leftVal == current.leftVal) {
	        current.left = new Node(leftVal, rightVal);
	    }
	    return current;
	}
	private static String traverseNode(Node node) {
		List<String> finalRoute = new ArrayList<>();
		if(node.left==null) {
			do {
				finalRoute.add(node.leftVal);
				finalRoute.add(node.rightVal);
				System.out.println(node.leftVal);
				System.out.println(node.rightVal);
			} while((node.right!=null));
		} else 
			traverseNode(getLeftmostNode(node.left));
		return finalRoute.stream().collect(Collectors.joining(", "));
	}
	
	private static Node getLeftmostNode(Node node) {
		if(node.left!=null)
			getLeftmostNode(node);
		return node;
	}
	public static String findRoutes2(ArrayList<ArrayList<String>> routes) {
		Node node = null;
		for(List<String> route : routes) {
			node = FindRoutes.addToNode(node, route.get(0), route.get(1));
		}
		return traverseNode(node);
	}
	
	private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static String findRoutes(ArrayList<ArrayList<String>> routes) {
		
		LinkedList<String> finalRoute = new LinkedList<>();
		//Using 0th element as placeholder
		finalRoute.addAll(routes.get(0));		
		for(int i=1; i<routes.size(); i++) {
			for(int j=1; j<routes.size(); j++) {
				LOGGER.log(Level.FINE, String.format("Comparing %s with final's last string: %s at i:%s j:%s", routes.get(j).get(0), finalRoute.get(finalRoute.size()-1), i, j));
				if(finalRoute.get(finalRoute.size()-1).equals(routes.get(j).get(0))) {
					finalRoute.addAll(finalRoute.size(), routes.get(j).stream().collect(Collectors.toCollection(LinkedList::new)));
				}
				LOGGER.log(Level.FINE, String.format("Comparing %s with final's first string: %s at i:%s j:%s", routes.get(j).get(routes.get(j).size()-1), finalRoute.get(0), i, j));
				if(finalRoute.get(0).equals(routes.get(j).get(routes.get(j).size()-1))) {
					finalRoute.addAll(0, routes.get(j).stream().collect(Collectors.toCollection(LinkedList::new)));
				}
			}
			LOGGER.log(Level.INFO, String.format("Updated FinalRoute while searching: %s", finalRoute.toString()));
		}
		if(finalRoute.size()!=routes.size()*2)
			throw new RuntimeException("Incomplete Route detected");
		return finalRoute.stream().distinct().collect(Collectors.joining(", "));
	}
	public static void main(String[] args) {
		System.out.println(findRoutes(new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("MNL", "TAG")), new ArrayList<String>(Arrays.asList("CEB", "TAC")), new ArrayList<String>(Arrays.asList("TAG", "CEB")), new ArrayList<String>(Arrays.asList("TAC", "BOR"))))));
		System.out.println(findRoutes2(new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("MNL", "TAG")), new ArrayList<String>(Arrays.asList("CEB", "TAC")), new ArrayList<String>(Arrays.asList("TAG", "CEB")), new ArrayList<String>(Arrays.asList("TAC", "BOR"))))));
		//System.out.println(findRoutes(new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("Chicago", "Winnipeg")), new ArrayList<String>(Arrays.asList("Halifax", "Montreal")), new ArrayList<String>(Arrays.asList("Montreal", "Toronto")), new ArrayList<String>(Arrays.asList("Toronto", "Chicago")), new ArrayList<String>(Arrays.asList("Winnipeg", "Seattle"))))));
	}
}
