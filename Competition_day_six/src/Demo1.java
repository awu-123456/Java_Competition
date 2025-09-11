public class Demo1 {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        int x = nums[right];
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
