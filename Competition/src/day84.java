import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day84 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < sz; i++)
            {
                Node t = q.poll();
                tmp.add(t.val);
                for(Node child : t.children)
                {
                    if(child != null)
                        q.add(child);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
