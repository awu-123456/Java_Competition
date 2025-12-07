import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class day80 {
    Read read = new Read();
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];
        Arrays.sort(nums);
        dfsPermuteUnique(nums,0);
        return ret;
    }

    private void dfsPermuteUnique(int[] nums,int pos) {
        if(nums.length == pos) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!check[i] && (i == 0 || nums[i] != nums[i-1] || check[i-1])) {
                check[i] = true;
                path.add(nums[i]);
                dfsPermuteUnique(nums,pos+1);
                check[i] = false;
                path.remove(path.size()-1);
            }
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        dfsSubsets(nums,0);
        return ret;
    }

    private void dfsSubsets(int[] nums, int pos) {
        if(nums.length == pos) {
            ret.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[pos]);
        dfsSubsets(nums,pos+1);
        path.remove(path.size()-1);

        dfsSubsets(nums,pos+1);
    }


    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];
        dfsPermute(nums);
        return ret;
    }

    private void dfsPermute(int[] nums) {
        if(nums.length == path.size()) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!check[i]) {
                path.add(nums[i]);
                check[i] = true;
                dfsPermute(nums);
                path.remove(path.size()-1);
                check[i] = false;
            }
        }
    }

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / pow(x,-n) : pow(x,n);
    }

    private double pow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        double tmp = pow(x,n/2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfsHanota(A,B,C,A.size());
    }

    private void dfsHanota(List<Integer> a, List<Integer> b, List<Integer> c, int n) {
        if(n == 1) {
            c.add(a.remove(a.size()-1));
            return;
        }
        dfsHanota(a,c,b,n-1);
        c.add(a.remove(a.size()-1));
        dfsHanota(b,a,c,n-1);
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
