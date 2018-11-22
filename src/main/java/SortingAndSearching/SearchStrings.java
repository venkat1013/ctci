package SortingAndSearching;

public class SearchStrings {
    public int search(String[] strings, String searchString, int l, int u) {
        while (l <= u && strings[u] == ""){
            u--;
        }
        if(l > u){
            return -1;
        }
        while (l <= u){
            int m = (l + u)/2;
            while (strings[m] == ""){
                m++;
            }
            int r = strings[m].compareTo(searchString);
            if(r == 0){
                return m;
            }
            if(r > 0){
                u = m-1;
            }
            if(r < 0){
                l = m+1;
            }
        }
        return -1;
    }
    public int search(String[] strings, String searchString) {
        if(searchString == null || strings == null){
            return -1;
        }
        if(searchString == ""){
            for (int i=0;i<strings.length;i++){
                if(strings[i] == ""){
                    return i;
                }
            }
            return -1;
        }
        return search(strings,searchString,0,strings.length-1);
    }
}
