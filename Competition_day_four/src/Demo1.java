public class Demo1 {
    public int mySqrt(int x) {
        if(x < 1) {
            return 0;
        }
        int left = 1,right = x;
        while(left < right) {
            int mid = (left + right) / 2;
            if(mid * mid <= x) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}
