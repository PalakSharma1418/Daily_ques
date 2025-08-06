// Last updated: 8/6/2025, 4:42:18 PM
class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        ArrayList<Character> ll= new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(isvowel(ch)){
                ll.add(ch);
            }
        }
        Collections.sort(ll);
         String ans="";
        int in=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(isvowel(c)){
                ans=ans+ll.get(in++);
            }else{
                ans=ans+c;
            }
        }   
        return ans;

    }
    public static boolean isvowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            return true;
        }
        return false;
    }
}