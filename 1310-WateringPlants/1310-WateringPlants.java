// Last updated: 8/6/2025, 4:45:48 PM
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int bucket=capacity;
        int steps=0;
        for(int i=0;i<plants.length;i++){
            if(bucket>=plants[i]){
                steps+=1;
                bucket=bucket-plants[i];
            }
            else{
                steps=steps+(i)+(i+1);
                bucket=capacity-plants[i];
            }
        }
        return steps;
    }
}