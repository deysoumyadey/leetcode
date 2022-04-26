package DS1;
/**
 * 
 * @author soumya
 * 
 * 566. Reshape the Matrix
 *
 */
public class ReshapeMatrix {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c)
            return mat;
        int[][] result = new int[r][c];
        int a=0, b=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                result[a][b++]=mat[i][j];
                if(b==c){
                    a++;
                    b=0;
                }
            }
        }
        return result;
    }
}
