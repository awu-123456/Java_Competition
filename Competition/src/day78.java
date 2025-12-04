import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class day78 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int left = 0,right = 0,maxPos = 0,ret = 0;
        while(left <= right) {
            if(maxPos >= n - 1) {
                return true;
            }
            for(int i = left;i <= right;i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            left = right + 1;
            right = maxPos;
            ret++;
        }
        return false;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0,right = 0,maxPos = 0,ret = 0;
        while(left <= right) {
            if(maxPos >= n - 1) {
                return ret;
            }
            for(int i = left;i <= right;i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            left = right + 1;
            right = maxPos;
            ret++;
        }
        return -1;
    }

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sf = new StringBuilder();
        if(n == 1) {
            return sf.append(nums[0]).toString();
        }
        if(n == 2) {
            return sf.append(nums[0]).append('/').append(nums[1]).toString();
        }
        sf.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2;i < n;i++) {
            sf.append("/").append(nums[i]);
        }
        sf.append(")");
        return sf.toString();
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ng = g.length;
        int ns = s.length;
        int ret = 0;
        for(int i = 0,j = 0;i < ng && j < ns;i++,j++) {
            while(j < ns && s[j] < g[i]) {
                j++;
            }
            if(j < ns) {
                ret++;
            }
        }
        return ret;
    }
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ret = new int[n+1];
        int left = 0,right = n;
        for(int i = 0;i < n;i++) {
            if(s.charAt(i) == 'I') {
                ret[i] = left++;
            } else {
                ret[i] = right--;
            }
        }
        ret[n] = left;
        return ret;
    }

    public int longestPalindrome(String s) {
        int[] hash = new int[127];
        char[] ch = s.toCharArray();
        for(char c : ch) {
            hash[c]++;
        }
        int ret = 0;
        for(int x : hash) {
            ret += x / 2 * 2;
        }
        return ret < s.length() ? ret + 1 : ret;
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] index = new Integer[n];
        for(int i = 0;i < n;i++) {
            index[i] = i;
        }
        Arrays.sort(index,(i,j) -> {
            return heights[j] - heights[i];
        });
        String[] ret = new String[n];
        for(int i = 0;i < n;i++) {
            ret[i] = names[index[i]];
        }
        return ret;
    }
    Read read = new Read();
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

}
class Read {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        if(!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    String nextLine() throws IOException {
        return bf.readLine();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
