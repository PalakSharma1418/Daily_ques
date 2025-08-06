// Last updated: 8/6/2025, 4:40:59 PM
class Solution {
    public int minSwaps(int[] nums) {
        int n= nums.length;
        int digit[][]= new int[n][3];
        for(int i=0;i<n;i++){
            digit[i][0]=sum(nums[i]);
            digit[i][1]=nums[i];
            digit[i][2]=i;
        }
        Arrays.sort(digit, (a,b) ->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        boolean visited[]= new boolean[n];
        int s=0;
        for(int i=0;i<n;i++){
            if(visited[i] || digit[i][2]==i){
                continue;
            }
            int j=i;
            int c=0;
            while(!visited[j]){
                visited[j]= true;
                j= digit[j][2];
                c++;
            }
            if(c>1){
                s+=c-1;
            }
            
        }
        return s;
    }
    public int sum(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n= n/10;
        }
        return s;
    }
}