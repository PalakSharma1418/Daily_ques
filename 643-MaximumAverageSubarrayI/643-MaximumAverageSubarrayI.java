// Last updated: 8/6/2025, 4:47:19 PM
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0,avg,maxavg;
        int i,c=0;
        for(i=0;i<k;i++)
        {
            sum=sum+nums[i];
        }
        avg=sum/k;
        maxavg=avg;
        for(i=k;i<nums.length;i++)
        {
            sum=sum+nums[i]-nums[c];
            c++;
            avg=sum/k;
            if(maxavg<avg)
            {
                maxavg=avg;
            }
        }
        return maxavg;
    }
}