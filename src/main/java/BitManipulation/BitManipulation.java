package BitManipulation;

public class BitManipulation {
    public static int updateBits(int n,int m,int i,int j){
        int max = ~0;
        int temp1 = max - (1<<j - 1);
        int temp2 = (1<<i) - 1;
        int mask = temp1 | temp2;
        return (n & mask) | (m << i);
    }

    public static boolean getBit(int n,int index){
        return ((n & (1<<index)) > 0);
    }

    public static void setBit(int n,int index, boolean v) {
        if(v) {
            n = n | (1 << index);
        }
        else {
            n = n & ~(1 << index);
        }
    }


}
