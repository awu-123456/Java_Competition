import java.util.HashMap;
import java.util.Map;

public class day73 {
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(hash.containsKey(nums[i]))
            {
                if(i - hash.get(nums[i]) <= k) return true;
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}
