import java.util.Arrays;

public class day15 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public boolean isUnique(String astr) {
        if(astr.length() > 26) {
            return false;
        }
        int ret = 0;
        for(int i = 0;i < astr.length();i++) {
            int ch = astr.charAt(i) - 'a';
            if(((ret >> ch) & 1) == 1 ){
                return false;
            } else {
                ret |= (1 << ch);
            }
        }
        return true;
    }
}
