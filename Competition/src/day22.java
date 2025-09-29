public class day22 {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int d = 2 * numRows - 2;
        for(int i = 0;i < n;i += d) {
            ret.append(s.charAt(i));
        }
        for(int k = 1;k < numRows-1;k++) {
            for(int i = k,j = d - i;i < n || j < n;i += d,j += d) {
                if(i < n) {
                    ret.append(s.charAt(i));
                }
                if(j < n) {
                    ret.append(s.charAt(j));
                }
            }
        }
        for(int i = numRows-1;i < n;i += d) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }
}
