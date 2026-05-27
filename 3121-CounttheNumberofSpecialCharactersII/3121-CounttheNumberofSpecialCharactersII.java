// Last updated: 5/27/2026, 8:14:53 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int [] arr= new int[26];
4        int Arr[]=new int[26];
5        java.util.Arrays.fill(arr, -1);
6        java.util.Arrays.fill(Arr, -1);
7        for(int i=0; i < word.length();i++){
8            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
9                if(Arr[word.charAt(i)-'A']==-1){
10                     Arr[word.charAt(i)-'A']=i;
11                }
12               
13            }
14            else{
15                // if(arr[i]==-1){
16                arr[word.charAt(i)-'a']=i;
17                // }
18            }
19        } int c=0;
20        for(int j=0;j<26;j++){
21            if(arr[j]!=-1 && Arr[j]!=-1){
22                if(arr[j]<Arr[j]){
23                c++;
24                }
25            }
26        }
27        return c;
28    }
29}