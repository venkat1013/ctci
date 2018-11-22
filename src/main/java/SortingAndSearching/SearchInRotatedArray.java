package SortingAndSearching;

public class SearchInRotatedArray {
    public static int Search(int[] array, int l, int u, int x){
        if(l < 0 || l >u){
            return -1;
        }
        while (l <= u){
            int m = (l + u)/2;
            if(array[m] == x){
                return m;
            }
            else if(array[l] <= array[m]){
                if(x < array[m]){
                    u = m-1;
                }
                else {
                    l = m + 1;
                }
            }
            else {
                if(x > array[m]) {
                    u = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
