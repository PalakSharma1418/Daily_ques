// Last updated: 8/6/2025, 4:49:01 PM
class Solution {
    //  Boyer-Moore Voting Algorithm
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int elt1=Integer.MIN_VALUE;//random
        int elt2=Integer.MIN_VALUE;//random
        for(int i=0;i<nums.length;i++){
            if(nums[i]==elt1){
                count1++;
            }
            else if(nums[i]==elt2){
                count2++;
            }
            else if(count1==0 && nums[i]!=elt2){
                elt1=nums[i];
                count1=1;
            }
            else if(count2==0){
                elt2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        int length=nums.length/3;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==elt1){
                count1++;
            }
            if(nums[i]==elt2){
                count2++;
            }  
        }
        if(count1>length) ans.add(elt1);
        if(count2>length) ans.add(elt2);
        return ans;
    }
}
// https://youtu.be/vwZj1K0e9U8?si=25MUEIgpNikF1-bA