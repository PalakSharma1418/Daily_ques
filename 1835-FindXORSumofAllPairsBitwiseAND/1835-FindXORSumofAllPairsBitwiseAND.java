// Last updated: 1/21/2026, 12:09:23 PM
1class Solution {
2    public int getXORSum(int[] arr1, int[] arr2) {
3        int xor1=0;
4        for(int n: arr1){
5            xor1^=n;
6        }
7        int xor2=0;
8        for(int n : arr2){
9            xor2^=n;
10        }
11        return xor1&xor2;
12    }
13}