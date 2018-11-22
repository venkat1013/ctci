package RecursionAndDynamicProgramming;

public class StairCaseExample {
    public static int CountWays(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        else {
            return CountWays(n-1)+CountWays(n-2)+CountWays(n-3);
        }
    }
    public static int CountWaysDP(int n,int[] map) {
        if (n < 0) {
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(map[n] > -1){
            return map[n];
        }
        map[n] = CountWaysDP(n-1,map)+CountWaysDP(n-2,map)+CountWaysDP(n-3,map);
        return map[n];
    }
}
