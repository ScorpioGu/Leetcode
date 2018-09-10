package array;

public class 时间序列每个时间点持续一段时间求总的持续时间 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length==0 || duration <= 0)
        	return 0;
        int sum = 0;
        for(int i=0; i<timeSeries.length-1; i++) {
        	int gap = timeSeries[i+1]-timeSeries[i];
        	sum += gap>duration?duration:gap;
        }
        sum+=duration;
        return sum;
    }
}
