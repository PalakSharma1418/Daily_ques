// Last updated: 8/6/2025, 4:41:27 PM
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n= instructions.length;
        int i=0;
        long score= 0;
        Set<Integer> visited= new HashSet<>();
        while(i>=0 && i<n && !visited.contains(i)){
            visited.add(i);
            if(instructions[i].equals("add")){
                score+=values[i];
                i++;
            }
            else{
                i+=values[i];
            }
        }
        return score;
    }
}