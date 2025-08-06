// Last updated: 8/6/2025, 4:49:36 PM
 class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String [] arr=s.split("\s+");
        String ans="";
        for(int i=arr.length-1;i>=0;i--){
            ans = ans+arr[i]+" ";
        }
        return ans.trim();
    }
}
