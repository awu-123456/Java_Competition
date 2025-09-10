public class Demo1 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1,right = arr.length-2;
        while(left < right) {
            int mid = (left + right + 1) / 2;
            if(arr[mid] > arr[mid-1]) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
    public int peakIndexInMountainArray1(int[] arr) {
        for(int i = 1;i < arr.length-1;i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }
}
