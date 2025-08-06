// Last updated: 8/6/2025, 4:42:55 PM
class Solution {
    public int countDistinctIntegers(int[] nums) {
        int [] fin= new int[nums.length *2];
        for(int i=0;i<nums.length;i++){
            fin[i]= nums[i];
        }
        int k=0;
        for(int i= nums.length;i<fin.length;i++){
            int f=0;
            int n= nums[k++];
            while(n>0){
                int r= n%10;
                f=f*10+r;
                n/=10;
            }
            fin[i]=f;
        }
        Arrays.sort(fin);
        int c=1;
        for(int i=0;i<fin.length-1;i++){
            if(fin[i]!=fin[i+1]){
                c++;
            }
        }
        return c;
    }
}
    // public int countDistinctIntegers(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         set.add(nums[i]);
    //         int temp = nums[i];
    //         int rev = 0;
    //         while (temp > 0) {
    //             int rem = temp % 10;
    //             rev = rev * 10 + rem;
    //             temp /= 10;
    //         }
    //         set.add(rev);
    //     }
    //     return set.size();
    // }