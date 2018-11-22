package RecursionAndDynamicProgramming;

public class MatrixGridExample {
    public static int countWays(int x,int y){
        if(x <0 || y <0){
            return 0;
        }
        if(x==0 && y==1){
            return 1;
        }
        if(x==1 && y==0){
            return 1;
        }
        if(x==1 && y==1){
            return 2;
        }
        return countWays(x-1,y) + countWays(x,y-1);
    }
    public static int CountWaysDP(int x, int y,int[][] map){
        if(x <0 || y <0){
            return 0;
        }
        if(x==0 && y==1){
            return 1;
        }
        if(x==1 && y==0){
            return 1;
        }
        if(x==1 && y==1){
            return 2;
        }
        if(map[x][y] > -1){
            return map[x][y];
        }
        map[x][y] = countWays(x-1,y) + countWays(x,y-1);
        return map[x][y];
    }
}
