public class Demo1 {
    public int takeAttendance(int[] records) {
        int left = 0,right = records.length-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(records[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(records[left] == left) {
            return left+1;
        } else {
            return left;
        }
    }
    public int takeAttendance1(int[] records) {
        if(records[0] != 0) {
            return 0;
        }
        for(int i = 1;i < records.length;i++) {
            if(records[i] - records[i-1] != 1) {
                return records[i]-1;
            }
        }
        return records[records.length-1]+1;
    }
}
