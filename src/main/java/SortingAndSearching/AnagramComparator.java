package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(o2);
    }

    public static void main(String[] args) {
        String[] array = new String[100];
        Arrays.sort(array,new AnagramComparator());
    }
}
