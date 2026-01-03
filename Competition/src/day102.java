import java.util.Stack;

public class day102 {
    public int[] solve (int[] a)
    {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        boolean[] hash = new boolean[n + 1];
        int aim = n;
        int[] ret = new int[n];
        int i = 0;
        for(int x : a)
        {
            st.push(x);
            hash[x] = true;
            while(hash[aim])
            {
                aim--;
            }
            while(!st.isEmpty() && st.peek() >= aim)
            {
                ret[i++] = st.peek();
                st.pop();
            }
        }
        return ret;
    }
}
