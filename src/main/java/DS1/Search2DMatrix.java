package DS1;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]<=target && target<=matrix[i][matrix[i].length-1]) {
            	for(int j=0; j<matrix[i].length; j++) {
            		if(matrix[i][j]==target)
            			return true;
            	}
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
          if(matrix[i][j] == target)
            return true;
          else if(matrix[i][j] > target)
            j --;
          else if(matrix[i][j] < target)
            i ++;
        }
        return false;
      }
}
