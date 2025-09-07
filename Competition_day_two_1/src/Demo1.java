public class Demo1 {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] hast1 = new int[128];
        int kind = 0;
        for(char ch : tt) {
            if(hast1[ch]++ == 0) kind++;
        }
        int[] hast2 = new int[128];
        int begin = -1;
        int minLen = Integer.MAX_VALUE;
        for(int left = 0,right = 0,count = 0;right < s.length();right++) {
            char in = ss[right];
            if(++hast2[in] == hast1[in]) {
                count++;
            }
            while(count == kind) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    begin = left;
                }
                char out = ss[left++];
                if(hast2[out]-- == hast1[out]) {
                    count--;
                }
            }
        }
        if(begin == -1) {
            return new String();
        } else {
            return s.substring(begin,begin + minLen);
        }
    }
}
