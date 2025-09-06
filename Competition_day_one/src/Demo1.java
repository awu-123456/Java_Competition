import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ret = new ArrayList<>();
            Map<String,Integer> hast1 = new HashMap<String,Integer>();
            for(String str : words) {
                hast1.put(str,hast1.getOrDefault(str,0)+1);
            }
            int len = words[0].length();
            int m = words.length;
            for(int i = 0;i < len;i++) {
                Map<String,Integer> hast2 = new HashMap<String,Integer>();
                for(int left = i,right = i,count = 0;right + len <= s.length();right += len) {
                    String in = s.substring(right,right + len);
                    hast2.put(in,hast2.getOrDefault(in,0)+1);
                    if(hast2.get(in) <= hast1.getOrDefault(in,0)) {
                        count++;
                    }
                    if(right - left + 1 > len * m) {
                        String out = s.substring(left,left + len);
                        if(hast2.get(out) <= hast1.getOrDefault(out,0)) {
                            count--;
                        }
                        hast2.put(out,hast2.get(out)-1);
                        left += len;
                    }
                    if(count == m) {
                        ret.add(left);
                    }
                }
            }
            return ret;
        }
    }
}
