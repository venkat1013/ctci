package RecursionAndDynamicProgramming;

public class PlaceQueen {
    static int columnForRow[] = new int[8];
    static boolean check(int row){
        for(int i=0;i<row;i++){
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if(diff == 0 || diff == row - i){
                return false;
            }
        }
        return true;
    }

    static void placeQueen(int row){
        if(row == 8){
            printBoard();
            return;
        }
        for(int i=0;i<8;i++){
            columnForRow[row] = i;
            if(check(row)) {
                placeQueen(row+1);
            }
        }
    }

    static void printBoard(){
        int[][] board = new int[8][8];
        for (int i=0;i < 8; i++){
            board[i][columnForRow[i]] = 1;
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        placeQueen(0);
    }

}
