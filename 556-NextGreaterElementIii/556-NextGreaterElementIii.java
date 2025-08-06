// Last updated: 8/6/2025, 4:47:33 PM
class Solution {
    public int nextGreaterElement(int n) {
        char arr[] = (Integer.toString(n)).toCharArray();
         StringBuilder ans = new StringBuilder();

         // Step 1: Find the first decreasing digit from the right
        int i=arr.length-2;
        while(i>=0 && arr[i] >= arr[i+1])
            i--;
        //if n element found
        if(i == -1)
            return -1;
        
        // Find the smallest digit larger than digits[i] to its right
        int k = arr.length-1;
        while(arr[k] <= arr[i])
            k--;
        
        swap(arr,i,k);
        
        for(int j=0;j<=i;j++)
            ans.append(arr[j]);
        
        for(int j=arr.length-1;j>i;j--)
            ans.append(arr[j]);//reverse the digits to the right of i
        
        long ans_ = Long.parseLong(ans.toString());
        return (ans_ > Integer.MAX_VALUE) ? -1 : (int)ans_;
        
        
    }
    void swap(char[] arr,int i,int j)
    {
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}