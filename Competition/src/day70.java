import java.util.*;

public class day70 {
    public static boolean[] vis = new boolean[15];
    public static int n;
    public static ArrayList<String> ret = new ArrayList<>();
    public static StringBuilder path = new StringBuilder();
    public static char[] s;
    public ArrayList<String> Permutation (String str) {
        n = str.length();
        s = str.toCharArray();
        Arrays.sort(s);
        dfs(0);
        return ret;
    }

    private void dfs(int pos) {
        if(pos == n) {
            ret.add(path.toString());
            return;
        }
        for(int i = 0;i < n;i++) {
            if(vis[i]) {
                continue;
            }
            if(i > 0 && s[i] == s[i-1] && !vis[i-1]) {
                continue;
            }
            vis[i] = true;
            path.append(s[i]);
            dfs(pos+1);
            vis[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ch = scanner.next().toCharArray();
        int[] arr = new int[26];
        int left = 0,right = 0;
        int n = ch.length;
        int count = 0;
        int ret = 0;
        while (right < n) {
            if(arr[ch[right] - 'a']++ == 0) {
                count++;
            }
            while(left < n&& count > 2) {
                if(arr[ch[left++] - 'a']-- == 1) {
                    count--;
                }
            }
            ret = Math.max(ret,right - left + 1);
            right++;
        }
        System.out.println(ret);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(1 << (n-1));
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            int x = target - nums[i];
            if(hash.containsKey(x)) {
                return new int[]{i,hash.get(x)};
            }
            hash.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public String multiply(String num1, String num2) {
        char[] number1 = new StringBuilder(num1).reverse().toString().toCharArray();
        int n1 = number1.length;
        char[] number2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int n2 = number2.length;
        int[] temp = new int[n1+n2-1];
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < n1;i++) {
            for (int j = 0;j < n2;j++) {
                temp[i + j] += (number1[i] - '0') * (number2[j] - '0');
            }
        }
        int cur = 0,t = 0;
        while(cur < n1 + n2 - 1 || t != 0) {
            if(cur < n1 + n2 - 1) {
                t += temp[cur++];
            }
            ret.append((char) (t % 10 + '0'));
            t /= 10;
        }
        while(ret.length() > 1 && ret.charAt(ret.length()-1) == '0') {
            ret.deleteCharAt(ret.length()-1);
        }
        return ret.reverse().toString();
    }

    public String addBinary(String a, String b) {
        StringBuilder aa = new StringBuilder(a).reverse();
        int n1 = a.length();
        StringBuilder bb = new StringBuilder(b).reverse();
        int n2 = b.length();
        StringBuilder ret = new StringBuilder();
        int cur1 = 0,cur2 = 0,t = 0;
        while(cur1 < n1 || cur2 < n2 || t != 0) {
            if(cur1 < n1) {
                t += (aa.charAt(cur1++) - '0');
            }
            if(cur2 < n2) {
                t += (bb.charAt(cur2++) - '0');
            }
            ret.append(t%2);
            t /= 2;
        }
        return ret.reverse().toString();
    }

    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int n = ss.length;
        int len = 0;
        int begin = 0;
        for(int i = 0;i < n;i++) {
            int left = i,right = i;
            while(left >= 0 && right < n && ss[left] == ss[right]) {
                left--;
                right++;
            }
            if(right - left - 1 > len) {
                len = Math.max(len,right - left - 1);
                begin = left + 1;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && ss[left] == ss[right]) {
                left--;
                right++;
            }
            if(right - left - 1 > len) {
                len = Math.max(len,right - left - 1);
                begin = left + 1;
            }
        }
        return s.substring(begin,begin+len);
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String ret = strs[0];
        for(int i = 1;i < n;i++) {
            ret = findSame(ret,strs[i]);
        }
        return ret;
    }

    private String findSame(String a, String b) {
        char[] s1 = a.toCharArray();
        int n1 = s1.length;
        char[] s2 = b.toCharArray();
        int n2 = s2.length;
        int i = 0;
        while(i < Math.min(n1,n2)) {
            if(s1[i] == s2[i]) {
                i++;
            } else {
                break;
            }
        }
        return a.substring(0,i);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0;i < n;i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr,(a,b) -> {
            return a[0] <= b[0] ? -1 : 1;
        });
        int ret = 0;
        int r = arr[0][1];
        for(int i = 1;i < n;i++) {
            if(arr[i][0] < r) {
                r = Math.min(r,arr[i][1]);
            } else {
                ret++;
                r = arr[i][1];
            }
        }
        System.out.println(ret+1);
    }
}
