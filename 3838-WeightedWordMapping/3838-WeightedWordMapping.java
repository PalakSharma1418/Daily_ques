// Last updated: 6/13/2026, 7:16:52 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        int n = words.length ;
4        int ans[] = new int[n];
5        for(int i=0 ; i<n ; i++){
6            String s = words[i];
7            int sum=0;
8            for(int j=0 ; j<s.length() ; j++){
9                char ch = s.charAt(j);
10                sum+=weights[ch-'a'];
11            }
12            ans[i]=(sum%26);
13        }
14
15        StringBuilder d = new StringBuilder();
16        for(int h=0; h<n ; h++){
17            char ff = (char)('z'-ans[h]);
18            d.append(ff);
19        }
20        return d.toString();
21        
22    }
23}