import java.util.HashMap;
import java.util.Map;

public class Demo1 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
        int sum = 0,ret = 0;
        for(int x : nums) {
            sum += x;
            ret += hash.getOrDefault(sum - k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return ret;
    }
}
