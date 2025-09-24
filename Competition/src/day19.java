public class day19 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ret = 0;
        for(int i = 0;i < timeSeries.length-1;i++) {
            if(timeSeries[i+1] - timeSeries[i] >= duration) {
                ret += duration;
            } else {
                ret += timeSeries[i+1] - timeSeries[i];
            }
        }
        ret += duration;
        return ret;
    }
}
