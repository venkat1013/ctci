package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class FindMagicIndex {
    public static int magicSlow(int[] array){
        for (int i=0;i<array.length;i++){
            if(array[i] == i){
                return i;
            }
        }
        return -1;
    }
    public static int magicImproved(int[] array){
        int val = magicImprovedHelper(array,0,array.length-1);
        return val;
    }
    public static int magicImprovedHelper(int[] array, int begin, int end){
        int mid = (begin + end)/2;
        if(begin > end){
            return -1;
        }
        if(array[mid] == mid){
            return mid;
        }
        if(array[mid] > mid){
            return magicImprovedHelper(array,begin,mid-1);
        }
        else {
            return magicImprovedHelper(array,mid+1,end);
        }
    }
    public static int magicImprovedHelperHasDistinct(int[] array,int begin ,int end){
        int mid = (begin+end)/2;
        if(begin > end || begin <0 || end >= array.length) {
            return -1;
        }
        if(array[mid] == mid) {
            return mid;
        }
        int leftIndex = Math.min(array[mid],mid-1);
        int left = magicImprovedHelperHasDistinct(array,begin,leftIndex);
        if(left >= 0){
            return left;
        }
        int rightIndex = Math.max(mid+1,array[mid]);
        int right = magicImprovedHelperHasDistinct(array,mid+1,rightIndex);
        return right;
    }

    public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();
        for(int i=0;i<max;i++){
            int k =i;
            int index = 0;
            ArrayList<Integer> subSet = new ArrayList<Integer>();
            while (k > 0){
                if((k & 1) > 0){
                    subSet.add(set.get(index));
                }
                k = k >> 1;
                index++;
            }
            allSubsets.add(subSet);
        }
        return allSubsets;
    }

    public static ArrayList<String> getPermutations(String string) {
        ArrayList<String> permutations = new ArrayList<String>();
        char c = string.charAt(0);
        String substring = string.substring(1);
        ArrayList<String> words = getPermutations(substring);
        for(String word: words){
            for(int i=0;i<word.length();i++){
                permutations.add(insertCharAt(word,c,i));
            }
        }
        return permutations;
    }
    public static String insertCharAt(String word,char c,int i){
        String preindex = word.substring(0,i);
        String postindex = word.substring(i);
        return  preindex+c+postindex;
    }

    public static void printPar(int l, int r, char[] str,int count){
        if(l <0 || r < l){
            return;
        }
        if(l==0 && r==0){
            System.out.println(str);
        } else {
            if(l>0){
                str[count] = '(';
                printPar(l-1,r,str,count+1);
            }
            if(r>l){
                str[count] = ')';
                printPar(l,r-1,str,count+1);
            }
        }
    }

    public static void printPar(int count){
        char[] str = new char[count*2];
        printPar(count,count,str,0);

    }

    public static int makeChange(int n, int denom){
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for(int i=0; i * denom <= n; i++){
            ways += makeChange(n-i*denom,next_denom);
        }
        return ways;
    }

    public static void main(String[] args) {
        //printPar(3);
        System.out.println(makeChange(100,25));
    }
}
