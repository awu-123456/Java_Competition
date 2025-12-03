import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class day77 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length,elementMin = Integer.MAX_VALUE;
        int m = 0;
        for(int x : nums) {
            if(x < 0) {
                m++;
            }
            elementMin = Math.min(elementMin,Math.abs(x));
        }
        int sum = 0;
        if(m > k) {
            Arrays.sort(nums);
            for(int i = 0;i < k;i++) {
                sum += -nums[i];
            }
            for(int i = k;i < n;i++) {
                sum += nums[i];
            }
        } else {
            for (int x : nums) {
                sum += Math.abs(x);
            }
            if((k - m) % 2 != 0) {
                sum -= elementMin * 2;
            }
        }
        return sum;
    }

    public int maxProfit(int[] prices) {
        int ret = 0;
        for(int i = 1;i < prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                ret += (prices[i] - prices[i-1]);
            }
        }
        return ret;
    }

    public int maxProfit1(int[] prices) {
        int ret = 0;
        for(int i = 0,prevMin = Integer.MAX_VALUE;i < prices.length;i++) {
            ret = Math.max(ret,prices[i] - prevMin);
            prevMin = Math.min(prevMin,prices[i]);
        }
        return ret;
    }

    static Read read = new Read();
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int n = read.nextInt();
        int sum = 0;
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0;i < n;i++) {
            int a = read.nextInt();
            if(a >= 2500) {
                sum++;
                ret.add(i+1);
            }
        }
        pw.println(sum);
        int flg = 0;
        for(int x : ret) {
            if(flg == 1) {
                pw.print(" ");
            }
            pw.print(x);
            flg = 1;
        }
        pw.close();
    }

    public static void main3(String[] args) throws IOException {
        int n = read.nextInt();
        int sum = 0;
        for(int i = 0;i < n;i++) {
            int a = read.nextInt();
            sum += a;
        }
        pw.println(sum);
        pw.close();
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),m = scanner.nextInt();
        if(n % m == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a+b);
    }
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ret = 0;
        for(int i = 0;i < n;) {
            int j = i + 1;
            while(j < n && nums[j] > nums[j - 1]) {
                j++;
            }
            ret = Math.max(ret,j - i);
            i = j;
        }
        return ret;
    }
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int a = nums[0],b = Integer.MAX_VALUE;
        for(int i = 1;i < n;i++) {
            if(nums[i] > b) {
                return true;
            } else if(nums[i] > a) {
                b = nums[i];
            } else {
                a = nums[i];
            }
        }
        return false;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ret = new ArrayList<>();
        ret.add(nums[0]);
        for(int i = 1;i < n;i++) {
            if(ret.get(ret.size()-1) < nums[i]) {
                ret.add(nums[i]);
            } else {
                int left = 0,right = ret.size()-1;
                while(left < right) {
                    int mid = (left + right) / 2;
                    if(ret.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                ret.set(left,nums[i]);
            }
        }
        return ret.size();
    }
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int ret = 0,left = 0;
        for(int i = 0;i < n-1;i++) {
            int right = nums[i+1] - nums[i];
            if(right == 0) {
                continue;
            }
            if(left * right <= 0) {
                ret++;
            }
            left = right;
        }
        return ret+1;
    }
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
