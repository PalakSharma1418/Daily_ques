// Last updated: 8/6/2025, 4:45:02 PM
class Solution 
{
    public int minPartitions(String n) 
    {
        char[] arr = n.toCharArray();
        int max=-1;
        for(char c:arr)
        {
            max = Math.max(max,(int)c);
        }      
        return max-'0';
    }
}