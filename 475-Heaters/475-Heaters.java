// Last updated: 8/6/2025, 4:47:49 PM
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int left=0;
        int right=(int) 1e9;
         Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(isitpossible(houses,heaters,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean isitpossible(int[]house,int[] heater,int r){
        int i=0,j=0;
        while(i<house.length && j<heater.length){
            if(Math.abs(house[i] - heater[j]) <=r){
                i++;
            }else{
                j++;//dusre heater ki range dekhi
            }
        }
        return i==house.length;
    }
}