// Last updated: 9/14/2025, 7:15:26 PM
class Solution {
    public int smallestAbsent(int[] nums) {
        int n=nums.length;
        int sum=0;
        Set<Integer> set= new HashSet<>();
        for(int i: nums){
            set.add(i);
            sum+=i;
        }
        double av= (double) sum/n;
        int no= (int) Math.floor(av)+1;
        if(no<=0) no=1;
        while(true){
            if(set.contains(no)){
                no++;
            }else{
                return no;
            }
        }
    }
}