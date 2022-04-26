package DS1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        int start = 1;
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        for(int i=0; i<numRows; i++){
            List<Integer> innerList = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i)
                    innerList.add(1);
                else{
                    innerList.add((outerList.get(i-1).get(j-1))+(outerList.get(i-1).get(j)));
                }
            }
            outerList.add(innerList);
        }
        return outerList;
    }
	//Saves previous row
	public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = null;
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> save = new ArrayList<>();
            for (int j = 1; j <= i; j++)
                if (j == 1 || j == i) save.add(1);
                else save.add(pre.get(j-1) + pre.get(j-2));
            result.add(save);
            pre = save;
        }
        return result;
    }
}
