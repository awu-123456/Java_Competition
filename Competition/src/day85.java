import java.util.*;

public class day85 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while(!q.isEmpty())
        {
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < sz; i++)
            {
                TreeNode t = q.poll();
                tmp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            if(level % 2 == 0) Collections.reverse(tmp);
            ret.add(tmp);
            level++;
        }
        return ret;
    }
}
