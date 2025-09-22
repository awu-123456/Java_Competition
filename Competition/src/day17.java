public class day17 {
    public int[] missingTwo(int[] nums) {
        int tmp = 0;
        for(int x : nums) {
            tmp ^= x;
        }
        for (int i = 1;i <= nums.length+2;i++) {
            tmp ^= i;
        }
        int differ = 0;
        while(true)
        {
            if(((tmp >> differ) & 1) == 1) {
                break;
            }
            differ++;
        }
        int[] ret = new int[2];
        for(int x : nums) {
            if(((x >> differ) & 1) == 1) {
                ret[1] ^= x;
            } else {
                ret[0] ^= x;
            }
        }
        for(int i = 1;i <= nums.length+2;i++) {
            if(((i >> differ) & 1) == 1) {
                ret[1] ^= i;
            } else {
                ret[0] ^= i;
            }
        }
        return ret;
    }
}
