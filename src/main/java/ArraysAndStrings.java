import java.util.Arrays;
import java.util.Hashtable;

public class ArraysAndStrings {
    public static void setZeros(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++) {
            for(int j=0; j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if(row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }

        }
    }

    public static boolean isSubstring(String s1, String s2) {
        if(s1.contains(s2) || s2.contains(s1)) {
            return true;
        }
        return false;
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if(len == s2.length() && len >0) {
            String s1s1 = s1 + s1;
            return isSubstring(s2,s1s1);
        }
        return false;
    }

    public static void replaceFun(char[] str) {
        int newlength,spacecount=0;
        int length = str.length;
        for(int i=0; i<length; i++) {
            if(str[i] == ' ') {
                spacecount++;
            }
        }
        newlength = length + 2*spacecount;
        char[] replacedString = new char[newlength];
        for (int i=length-1; i>=0; i--) {
            if(str[i] == ' '){
                replacedString[newlength - 1] = '0';
                replacedString[newlength - 2] = '2';
                replacedString[newlength - 3] = '%';
                newlength = newlength - 3;
            }
            else {
                replacedString[newlength - 1] = str[i];
                newlength = newlength - 1;
            }
        }
        System.out.println("Replaced String"+replacedString.toString());
//        return replacedString;

    }
    public static void swapnumber(int a,int b) {
        System.out.println("Before replace:");
        System.out.print("a="+a);
        System.out.print(" b="+b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("\nAfter replace:");
        System.out.print("a="+a);
        System.out.print(" b="+b);
    }

    enum Check {Row, Column, Diagonal, ReverseDiagonal}

    enum Piece {Empty, Red, Blue}

    Piece getIthColor(Piece[][] board, int index, int var, Check  check) {
        if(check == Check.Row) return board[index][var];
        else if(check == Check.Column) return board[var][index];
        else if(check == Check.Diagonal) return board[var][var];
        else if(check == Check.ReverseDiagonal) return board[board.length - 1 -var][var];
        return Piece.Empty;
    }

    Piece getWinner(Piece[][] board, int fixed_index, Check check) {
        Piece color = getIthColor(board,fixed_index,0,check);
        for(int var=1; var<board.length; var++) {
            if(color != getIthColor(board,fixed_index,var,check)) {
                return Piece.Empty;
            }
        }
        return color;
    }

    Piece hasWon(Piece[][] board) {
        int N = board.length;
        Piece winner = Piece.Empty;
        for(int i=0;i<N;i++) {
            winner = getWinner(board,i,Check.Row);
            if(winner != Piece.Empty) {
                return winner;
            }
        }

        for(int i=0; i<N; i++) {
            winner = getWinner(board,i,Check.Column);
            if(winner != Piece.Empty) {
                return winner;
            }
        }

        winner = getWinner(board,-1,Check.Diagonal);
        if(winner != Piece.Empty) {
            return winner;
        }

        winner = getWinner(board,-1,Check.ReverseDiagonal);
        if(winner != Piece.Empty) {
            return winner;
        }

        return Piece.Empty;

    }

    public static int findLargerNumberNOComparision(int a, int b) {
        int c = a - b;
        int k = (c >> 31) & 0x1;
        int max = a - k * c;
        return max;
    }

    public static int numZeroes(int a) {
        int numZeroes = 0;
        for(int i=5;a/i>0;i=i*5){
            numZeroes += a/i;
        }
        return numZeroes;
    }

    public static class Result {
        public int hits;
        public int pseudoHits;
    }

    public static Result findHitsPseudoHits(String guess, String solution) {
        Result result = new Result();
        int solution_mask = 0;
        for(int i=0;i<4;i++) {
            solution_mask |= 1 << (1+solution.charAt(i) - 'A');
        }
        for (int i=0;i<4;i++) {
            if(guess.charAt(i) == solution.charAt(i)) {
                result.hits++;
            } else if((solution_mask & (1 << (1 + guess.charAt(i) - 'A'))) > 0) {
                result.pseudoHits++;
            }
        }
        return result;

    }

    public static int getMaxSum(int[] a) {
        int sum = 0;
        int maxsum = 0;
        int maxsum_temp_i = 0;
        int maxsum_i = 0;
        int maxsum_j = 0;
        for(int i=0;i<a.length; i++) {
            sum += a[i];
            if(maxsum < sum) {
                maxsum = sum;
                maxsum_i = maxsum_temp_i;
                maxsum_j = i;
            }
            if(sum < 0) {
                sum = 0;
                maxsum_temp_i = i+1;
            }
        }
        System.out.println("Indexes are:"+maxsum_i+" "+maxsum_j);
        return maxsum;
    }

    Hashtable<String, Integer> setUpDictionary(String[] book) {
        Hashtable<String,Integer> table = new Hashtable<String, Integer>();
        for(String word: book) {
            word = word.toLowerCase();
            if(word.trim() != "") {
                if(!table.contains(word)){
                    table.put(word,0);
                }
                else {
                    table.put(word,table.get(word)+1);
                }
            }

        }
        return table;
    }

    public static int getFrequency(Hashtable<String,Integer> table, String word) {
        word = word.toLowerCase();
        if(word.trim() != "") {
            if(table.contains(word)) {
                return table.get(word);
            }
        }
        return 0;
    }

    public static void printPairSums(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        for(first=0;first<last;first++) {
            while (array[first] + array[last] > sum) {
                last--;
            }
            if(array[first]+array[last] == sum) {
                System.out.println("The array numbers are:"+array[first]+" "+array[last]);
            }
        }
    }

    public static int sumNoAdditionOperator(int a,int b) {
        if(b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return sumNoAdditionOperator(sum, carry);
    }



    public static void main(String[] args) {
        System.out.println("Rotation of waterbottle and ttlewaterbo:"+ isRotation("waterbottle","ttlewaterbo"));
        System.out.println("Largest number:"+findLargerNumberNOComparision(15,14));
        System.out.println("Number of trailing zeroes in 25 factorial:"+numZeroes(25));
        Result result = findHitsPseudoHits("AABA","BAAA");
        System.out.println("Hits and Pseudo hits of YRGB and RGGB:"+result.hits+" "+result.pseudoHits);
        String initialString = "My name is John";
        int[] a = {2,-8,3,50,-2,50,-10,20,45};
        System.out.println("The maximum sum subarray is:"+getMaxSum(a));
        int[] array = {4,-5,23,17,6,0,19};
        printPairSums(array,23);
       replaceFun(initialString.toCharArray());
       swapnumber(3,4);
       System.out.println("Addtion of numbers"+sumNoAdditionOperator(0,50));
    }
}
