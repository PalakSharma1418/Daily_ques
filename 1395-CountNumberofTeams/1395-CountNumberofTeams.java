// Last updated: 1/20/2026, 2:41:08 PM
1class Solution {
2    public int numTeams(int[] rating) {
3        int n = rating.length;
4        int ans = 0 ;
5        for(int j =0 ; j < n ; j++){
6            int prevGreater=0;
7            int prevSmaller=0;
8
9            // previous 
10            for(int i =0 ; i<j; i++){
11                if(rating[i]<rating[j]) prevSmaller++;
12                if(rating[i]>rating[j]) prevGreater++;
13            }
14
15            int postGreater=0;
16            int postSmaller=0;
17
18            // post 
19            for(int k =j+1 ; k<n; k++){
20                if(rating[k]<rating[j]) postSmaller++;
21                if(rating[k]>rating[j]) postGreater++;
22            }
23
24            // i<j<k
25            ans+= prevSmaller*postGreater;
26            ans+= prevGreater*postSmaller;//i>j>k
27
28        }
29        return ans;
30    }
31}