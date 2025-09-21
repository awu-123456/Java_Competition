public class day16 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i = 0;i < 32;i++) {
            int sum = 0;
            for(int x : nums) {
                if(((x >> i) & 1) == 1) {
                    sum += 1;
                }
            }
            sum %= 3;
            if(sum == 1) {
                ret |= (1 << i);
            }
        }
        return ret;
    }

    public int getSum(int a, int b) {
        while(b != 0) {
            int x = a ^ b;
            int carry = (a & b) << 1;
            a = x;
            b = carry;
        }
        return a;
    }
}
