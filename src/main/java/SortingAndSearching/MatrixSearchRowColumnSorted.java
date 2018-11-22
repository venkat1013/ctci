package SortingAndSearching;

public class MatrixSearchRowColumnSorted {
    boolean FindEle(int[][] mat, int elem, int M, int N){
        int row = 0;
        int col = N-1;
        while (row < N && col >=0) {
            if (mat[row][col] == elem){
                return true;
            }
            else if(mat[row][col] > elem){
                col--;
            }
            else  {
                row++;
            }
        }
        return false;
    }
}
