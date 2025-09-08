public class Demo1 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        if(nums.length == 0) {
            return ret;
        }
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(nums[left] != target) {
            return ret;
        } else {
            ret[0] = left;
        }
        left = 0;
        right = nums.length-1;
        while(left < right) {
            int mid = (left + right + 1) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        ret[1] = left;
        return ret;
    }
}
