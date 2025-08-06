// Last updated: 8/6/2025, 4:45:29 PM
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        int n= s.length();
        for(int i=0;i<=n-k;i++){
            String sd= s.substring(i,i+k);
            seen.add(sd);
            if(seen.size()==Math.pow(2,k)){
                return true;
            }
        }
        
        return false;
    }
}