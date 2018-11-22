package SortingAndSearching;

import java.util.Comparator;

public class MegeTwoSortedArrays {

    public static void merge(int[] a, int[] b, int m, int n){
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (k >= 0 && i >= 0){
            if(a[i] >= b[j]) {
                a[k--] = a[i--];
            }
            else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0){
            a[k--] = b[j--];
        }
    }
}
