// Last updated: 1/31/2026, 4:57:41 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int i=0;
4        int j= letters.length-1;
5        char ch=letters[0];
6        while(i<=j){
7            int mid=i+(j-i)/2;
8            if(letters[mid]>target){
9                j=mid-1;
10                ch=letters[mid];
11            }
12            else  {
13                i=mid+1;
14            }
15        }
16        return ch;
17    }
18}
19