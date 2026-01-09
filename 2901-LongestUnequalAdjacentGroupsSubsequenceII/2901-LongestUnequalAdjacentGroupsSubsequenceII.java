// Last updated: 1/9/2026, 7:55:06 PM
1class Solution {
2    private int hamming(String s1, String s2){
3        int i = 0;
4        int j = 0;
5        int c = 0;
6        while(i < s1.length() && j < s2.length()){
7            if(s1.charAt(i) != s2.charAt(j)) c++;
8            i++;
9            j++;
10        }
11        return c;
12    }
13    
14    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
15        int n = words.length;
16        int[] dp = new int[n];
17        Arrays.fill(dp, 1);
18        int[] hash = new int[n];
19        
20        for(int i = 1; i < n; i++){
21            hash[i] = i; 
22            for(int j = 0; j < i; j++){
23                if(groups[i] != groups[j] && 
24                   words[i].length() == words[j].length() && 
25                   hamming(words[i], words[j]) == 1 && 
26                   1 + dp[j] > dp[i]){
27                    
28                    dp[i] = 1 + dp[j];
29                    hash[i] = j; 
30                }
31            }
32        }
33        
34        int max = -1;
35        int idx = -1;
36        for(int i = 0; i < n; i++){
37            if(dp[i] > max){
38                max = dp[i];
39                idx = i;
40            }
41        }
42        
43        List<String> ans = new ArrayList<>();
44        ans.add(0, words[idx]);
45        while(hash[idx] != idx){
46            idx = hash[idx];
47            ans.add(0, words[idx]);
48        }
49        return ans;
50    }
51}//y