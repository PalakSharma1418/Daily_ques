// Last updated: 8/6/2025, 4:46:36 PM
class Solution {
    public int totalFruit(int[] fruits) {
        int result =0;
        Map<Integer,Integer> count = new HashMap<>();
        int left=0;
        for(int right=0;right<fruits.length;right++){
            count.put(fruits[right],count.getOrDefault(fruits[right],0)+1);
            while(count.size()>2){
                count.put(fruits[left],count.get(fruits[left])-1);
                if(count.get(fruits[left])==0){
                    count.remove(fruits[left]);
                }
                left++;
            }
            result=Math.max(result,right-left+1);
        }


     return result;   
    }
}
// max length subarray with atmost 2 types of number