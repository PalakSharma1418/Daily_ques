// Last updated: 10/12/2025, 11:45:02 AM
class Solution {
    public int longestBalanced(String s) {
        int n =s.length();
        int m=0;
        for(int i=0;i<n;i++){
            int[] fr=new int[26];
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                fr[ch-'a']++;
                if(is(fr)){
                    m=Math.max(m,j-i+1);
                }
            }
        }
        return m;
    }
    public static boolean is(int[] fr){
        int c=0;
        for(int f:fr){
           if(f>0)
            {if(c==0) c=f;
            else if(c!=f) return false;}
        }
        return true;
    }
}