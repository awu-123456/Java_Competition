public class Demo2 {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(nums[right] < target) {
            return right + 1;
        } else {
            return right;
        }
    }
}
