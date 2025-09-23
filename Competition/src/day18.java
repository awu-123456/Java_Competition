public class day18 {
    public String modifyString(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        for(int i = 0;i < n;i++) {
            if(ss[i] == '?') {
                for(char ch = 'a';ch <= 'z';ch++) {
                    if((i == 0 || ch != ss[i-1]) && (i == n-1 || ch != ss[i+1]))
                    {
                        ss[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(ss);
    }
}
