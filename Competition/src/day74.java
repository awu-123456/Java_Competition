import java.util.*;

public class day74 {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> hash = new HashMap<>();
        for(String s : strs)
        {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if(!hash.containsKey(key))
            {
                hash.put(key, new ArrayList());
            }
            hash.get(key).add(s);
        }
        return new ArrayList(hash.values());
    }
}
