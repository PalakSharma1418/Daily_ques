// Last updated: 5/29/2026, 7:34:06 PM
1class Solution {
2    public int minElement(int[] nums) {
3        int min =100000;
4        for(int num: nums){
5            min=Math.min(sum(num), min);
6        }
7        return min;
8    }
9    public int sum(int num){
10        int rem=0;
11        while(num>0){
12            rem+=num%10;
13            num/=10;
14        }
15        return rem;
16    }
17}