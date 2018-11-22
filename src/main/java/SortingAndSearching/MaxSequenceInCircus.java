package SortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;

public class MaxSequenceInCircus {
    class HtWt {
        int weight;
        int height;
    }
    ArrayList<HtWt> items;
    ArrayList<HtWt> lastFoundSeq;
    ArrayList<HtWt> maxSeq;

    ArrayList<HtWt> seqWithMaxLenght(ArrayList<HtWt> sq1, ArrayList<HtWt> sq2){
        return sq1.size() > sq2.size() ? sq1: sq2;
    }

    void findMaxSeq() {
        Collections.sort(items);
    }
}
