// Last updated: 8/6/2025, 4:43:08 PM
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int ans = -1;
        for(int num : nums){
            int sum = sd(num);
            if(map.containsKey(sum)){
                ans = Math.max(ans, num + map.get(sum)); // Check max sum of this pair
                if(num > map.get(sum)){
                    map.put(sum, num); // Update max number for this digit sum
                }
            } else {
                map.put(sum, num); // Store the first number with this digit sum
            }
        }


        return ans;
    }

    public int sd(int num){
        int sum =0;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }

        return sum;
    }
} 