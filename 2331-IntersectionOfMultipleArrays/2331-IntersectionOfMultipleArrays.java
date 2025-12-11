// Last updated: 12/11/2025, 7:35:08 AM
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int array[] = new int[1001];
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < nums[i].length; j++){
                array[nums[i][j]]++;
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] == len){
                result.add(i);
            }
        }
        return result;
    }
}