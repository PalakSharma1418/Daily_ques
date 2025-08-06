// Last updated: 8/6/2025, 4:47:16 PM
class Solution {
     public static boolean ispallidrom(String s1){
        int i=0;
        int j=s1.length()-1;
        while(i<j){
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            } i++;
            j--;
        }
        return true;
       
    }
    public int countSubstrings(String s) {
        int j=0,count=0;
        for(int i=0;i<s.length();i++){
            j=i;
            while(j < s.length()){
                String sub= s.substring(i, j+1);
                if(ispallidrom(sub)){
                    count++;
                }
                j++;
            }
        }
        return count;
    }
}