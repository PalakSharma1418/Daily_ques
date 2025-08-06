// Last updated: 8/6/2025, 4:43:55 PM
class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> nums = new ArrayList<>();
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                nums.add(grid[i][j]);
            }
        }
        Collections.sort(nums);
        int len= nums.size();
        int commonno= nums.get(len/2);
        for(int num : nums){
            if(num%x != commonno%x){
                return -1;
            }
        
        res += Math.abs(commonno - num)/x;}
    
    return res;}
}