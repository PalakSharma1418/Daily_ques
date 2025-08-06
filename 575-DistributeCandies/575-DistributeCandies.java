// Last updated: 8/6/2025, 4:47:30 PM
class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        int t=1;
        Arrays.sort(candyType);
        for(int i=1;i<n;i++){
            if(candyType[i-1]!=candyType[i]){
                t++;
            }
        }
        if(t>n/2){
            return n/2;
        }
        return t;
    }
}