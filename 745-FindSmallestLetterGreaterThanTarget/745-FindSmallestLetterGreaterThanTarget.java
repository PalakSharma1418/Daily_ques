// Last updated: 8/6/2025, 4:47:00 PM
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i=0;
        int j= letters.length-1;
        char ch=letters[0];
        while(i<=j){
            int mid=i+(j-i)/2;
            if(letters[mid]>target){
                j=mid-1;
                ch=letters[mid];
            }
            else  {
                i=mid+1;
            }
        }
        return ch;
    }
}
