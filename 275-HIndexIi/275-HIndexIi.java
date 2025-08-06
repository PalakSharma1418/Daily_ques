// Last updated: 8/6/2025, 4:48:45 PM

class Solution { 
    public int hIndex(int[] citations) {
        int n = citations.length; 
        if (n == 1) {
            return citations[0] == 0 ? 0 : 1;
        }

        int lo = 0; 
        int hi = n - 1; 
        int ans = 0; 

        while (lo <= hi) {
            int mid = (lo + hi) / 2; 
            int papersWithAtLeastMidCitations = n - mid;
            if (citations[mid] >= papersWithAtLeastMidCitations) {
                ans = papersWithAtLeastMidCitations; 
                hi = mid - 1; 
            } else {
                lo = mid + 1; 
            }
        }

        return ans;
    }
}
