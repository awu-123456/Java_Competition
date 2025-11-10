import java.util.ArrayList;
import java.util.List;

public class day52 {
    int[] index;
    int[] tmpNums;
    int[] tmpIndex;
    int[] ret;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        index = new int[n];
        tmpNums = new int[n];
        tmpIndex = new int[n];
        ret = new int[n];
        for(int i = 0;i < n;i++) {
            index[i] = i;
        }
        mergeSort(nums,0,n-1);
        List<Integer> l = new ArrayList<>();
        for(int x : ret) {
            l.add(x);
        }
        return l;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        int cur1 = l,cur2 = mid+1,i = 0;
        while(cur1 <= mid && cur2 <= r) {
            if(nums[cur1] <= nums[cur2]) {
                tmpNums[i] = nums[cur2];
                tmpIndex[i++] = index[cur2++];
            } else {
                ret[index[cur1]] += (r - cur2 + 1);
                tmpNums[i] = nums[cur1];
                tmpIndex[i++] = index[cur1++];
            }
        }
        while(cur1 <= mid) {
            tmpNums[i] = nums[cur1];
            tmpIndex[i++] = index[cur1++];
        }
        while(cur2 <= r) {
            tmpNums[i] = nums[cur2];
            tmpIndex[i++] = index[cur2++];
        }
        for(int j = l;j <= r;j++) {
            nums[j] = tmpNums[j - l];
            index[j] = tmpIndex[j - l];
        }
    }

    int[] tmp;
    public int reversePairs(int[] record) {
        tmp = new int[record.length];
        int ret = mergeSort2(record,0,record.length-1);
        return ret;
    }

    private int mergeSort2(int[] record, int l, int r) {
        if(l >= r) {
            return 0;
        }
        int ret = 0;
        int mid = (l + r) / 2;
        ret += mergeSort2(record,l,mid);
        ret += mergeSort2(record,mid + 1,r);
        int cur1 = l,cur2 = mid + 1,i = 0;
        while(cur1 <= mid && cur2 <= r) {
            if(record[cur1] <= record[cur2]) {
                tmp[i++] = record[cur1++];
            } else {
                ret += (mid - cur1 + 1);
                tmp[i++] = record[cur2++];
            }
        }
        while(cur1 <= mid) {
            tmp[i++] = record[cur1++];
        }
        while(cur2 <= r) {
            tmp[i++] = record[cur2++];
        }
        for(int j = l;j <= r;j++) {
            record[j] = tmp[j - l];
        }
        return ret;
    }

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort1(nums,0,nums.length-1);
        return nums;
    }

    private void mergeSort1(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort1(nums,l,mid);
        mergeSort1(nums,mid+1,r);
        int cur1 = l,cur2 = mid + 1,i = 0;
        while(cur1 <= mid && cur2 <= r) {
            tmp[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];
        }
        while(cur1 <= mid) {
            tmp[i++] = nums[cur1++];
        }
        while(cur2 <= r) {
            tmp[i++] = nums[cur2++];
        }
        for(int j = l;j <= r;j++) {
            nums[j] = tmp[j - l];
        }
    }
}
