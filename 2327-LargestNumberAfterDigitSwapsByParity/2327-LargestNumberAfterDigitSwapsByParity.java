// Last updated: 8/6/2025, 4:43:31 PM
class Solution {
     public int largestInteger(int n){
        char[] a = String.valueOf(n).toCharArray();
        for(int i = 0; i < a.length; i++)
            for(int j = i + 1; j < a.length; j++)
                if(a[j] > a[i] && (a[j] - a[i]) % 2 == 0){
                    char t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
        return Integer.parseInt(new String(a));
    }
}