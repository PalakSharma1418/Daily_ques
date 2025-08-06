// Last updated: 8/6/2025, 4:49:26 PM
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int list[]=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<=right){
                if(numbers[left]+numbers[right]==target){
                    list[0]=left+1;
                    list[1]=right+1;
                    break;
                }
                else if(numbers[left]+numbers[right]<target){
                    left++;//array sorted so ye chota hoga to aage bandna 
                }
                else{
                    right--;
                }
        }
        return list;
    }
}