// Last updated: 3/1/2026, 8:57:31 AM
1class Solution 
2{
3    public int minPartitions(String n) 
4    {
5        char[] arr = n.toCharArray();
6        int max=-1;
7        for(char c:arr)
8        {
9            max = Math.max(max,(int)c);
10        }      
11        return max-'0';
12    }
13}