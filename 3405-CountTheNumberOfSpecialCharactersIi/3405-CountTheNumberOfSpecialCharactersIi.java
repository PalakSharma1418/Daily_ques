// Last updated: 8/6/2025, 4:41:57 PM
class Solution {
    public int numberOfSpecialChars(String word) {
        int [] arr= new int[26];
        int Arr[]=new int[26];
        java.util.Arrays.fill(arr, -1);
        java.util.Arrays.fill(Arr, -1);
        for(int i=0; i < word.length();i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                if(Arr[word.charAt(i)-'A']==-1){
                     Arr[word.charAt(i)-'A']=i;
                }
               
            }
            else{
                // if(arr[i]==-1){
                arr[word.charAt(i)-'a']=i;
                // }
            }
        } int c=0;
        for(int j=0;j<26;j++){
            if(arr[j]!=-1 && Arr[j]!=-1){
                if(arr[j]<Arr[j]){
                c++;
                }
            }
        }
        return c;
    }
}