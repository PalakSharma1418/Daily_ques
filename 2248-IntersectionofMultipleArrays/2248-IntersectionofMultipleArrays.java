// Last updated: 10/27/2025, 8:31:46 PM
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