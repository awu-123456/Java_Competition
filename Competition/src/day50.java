import java.util.Random;

class day50 {
    public int[] sortArray(int[] nums)
    {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }
    public void qsort(int[] nums, int l, int r)
    {
        if(l >= r) return;
        int key = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1, right = r + 1, i = l;
        while(i < right)
        {
            if(nums[i] < key) swap(nums, ++left, i++);
            else if(nums[i] == key) i++;
            else swap(nums, --right, i);
        }
        // [l, left] [left + 1, right - 1] [rigth, r]
        qsort(nums, l, left);
        qsort(nums, right, r);
    }
    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
