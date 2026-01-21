// Last updated: 1/21/2026, 11:32:28 AM
1class Solution {
2    public boolean doesValidArrayExist(int[] derived) {
3        int xor = derived[0];
4        for(int i=1 ; i< derived.length ; i++){
5            int no=derived[i];
6            xor^=no;
7        }
8        return xor==0;
9    }
10}
11// [a,b,c]
12// [a^b , b^c , c^a]