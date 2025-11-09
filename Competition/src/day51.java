import java.util.Random;

public class day51 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        qsort(stock,0,stock.length-1);
        int[] arr = new int[cnt];
        for(int i = 0;i < cnt;i++) {
            arr[i] = stock[i];
        }
        return arr;
    }
    public int findKthLargest(int[] nums, int k) {
        qsort(nums,0,nums.length-1);
        return nums[nums.length - k];
    }

    public int[] sortArray(int[] nums) {
        qsort(nums,0,nums.length-1);
        return nums;
    }

    private void qsort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int key = nums[new Random().nextInt(r - l + 1)+l];
        int left = l-1,i = l,right = r+1;
        while(i < right) {
            if(nums[i] < key) {
                swap(nums,++left,i++);
            } else if(nums[i] == key) {
                i++;
            } else {
                swap(nums,--right,i);
            }
        }
        qsort(nums,l,left);
        qsort(nums,right,r);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
