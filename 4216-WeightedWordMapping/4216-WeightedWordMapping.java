// Last updated: 2/18/2026, 11:34:34 AM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length ;
        int ans[] = new int[n];
        for(int i=0 ; i<n ; i++){
            String s = words[i];
            int sum=0;
            for(int j=0 ; j<s.length() ; j++){
                char ch = s.charAt(j);
                sum+=weights[ch-'a'];
            }
            ans[i]=(sum%26);
        }

        StringBuilder d = new StringBuilder();
        for(int h=0; h<n ; h++){
            char ff = (char)('z'-ans[h]);
            d.append(ff);
        }
        return d.toString();
        
    }
}