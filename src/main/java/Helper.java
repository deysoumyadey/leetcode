import java.util.*;

public class Helper {
  // Helpers
  public static List<List<Integer>> fromArray(Integer[][] raw){
    List<List<Integer>> m = new ArrayList<List<Integer>>();
    for (Integer[] row : raw) {
      m.add(Arrays.asList(row)); 
    }
    return m;
  }
  public static String printMatrix(List<List<Integer>> mtx) { 
    StringBuilder sb = new StringBuilder(); 
    mtx.forEach((e) -> {
      sb.append(printList(e, ","));
      sb.append("\n");
      });
    return sb.toString();
  }
  public static String printList(List<Integer> l, String del){
    StringBuilder sb = new StringBuilder();
    l.forEach((e)-> { sb.append(e.toString() + del); });
    return sb.toString();
  }
}