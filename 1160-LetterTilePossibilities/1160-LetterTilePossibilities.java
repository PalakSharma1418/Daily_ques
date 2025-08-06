// Last updated: 8/6/2025, 4:46:03 PM
class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> subset = new  ArrayList<>();
        print(tiles,"",subset);
        return subset.size() - 1;
    }
    public static void print(String ques,String ans,List<String> subset){
        subset.add(ans);
        for(int i=0;i<ques.length();i++){
            char ch= ques.charAt(i);
            if(!is_valid(ques,i+1,ch))
            {
            String s1= ques.substring(0, i);
            String s2 = ques.substring(i+1);
            print(s1+s2,ans+ch,subset);
            }
        }
    }
    public static boolean is_valid(String str,int i, char ch){
        for(int j=i;j<str.length();j++){
            if(str.charAt(j)==ch){
                return true;
            }
        }
        return false;
    }
}