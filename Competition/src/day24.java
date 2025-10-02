import java.util.HashMap;
import java.util.Map;

public class day24 {
    public int minNumberOfFrogs(String c) {
        char[] croakOfFrogs = c.toCharArray();
        String t = "croak";
        int n = t.length();
        int[] hash = new int[n];
        Map<Character,Integer> index = new HashMap<>();
        for(int i = 0;i < n;i++) {
            index.put(t.charAt(i),i);
        }
        for(char ch : croakOfFrogs) {
            if(ch == t.charAt(0)) {
                if(hash[n-1] != 0) {
                    hash[n-1]--;
                }
                hash[0]++;
            } else {
                int j = index.get(ch);
                if(hash[j-1] == 0) {
                    return -1;
                }
                hash[j-1]--;
                hash[j]++;
            }
        }
        for(int i = 0;i < n-1;i++) {
            if(hash[i] != 0) {
                return -1;
            }
        }
        return hash[n-1];
    }
}
