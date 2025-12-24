// Last updated: 12/24/2025, 7:38:09 AM
1class Solution {
2    public int findMinimumOperations(String s1, String s2, String s3) {
3        int i=0;
4        int n=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
5        int ans=-1;
6        for(i=0;i<n;i++){
7            if(s1.charAt(i)==s2.charAt(i)&&s2.charAt(i)==s3.charAt(i)){
8                continue;
9            }
10            break;
11        }
12        if(i==0){
13            return -1;
14        }
15        ans=0;
16        ans+=s1.length()-i;
17        ans+=s2.length()-i;
18        ans+=s3.length()-i;
19        return ans;
20    }
21}