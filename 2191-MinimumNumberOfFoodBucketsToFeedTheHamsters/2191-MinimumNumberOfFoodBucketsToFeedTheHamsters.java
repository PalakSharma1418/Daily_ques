// Last updated: 1/9/2026, 10:55:37 AM
class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int buckets = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; ) {

            if (hamsters.charAt(i) == 'H') {
                if ((i - 1 >= 0 && set.contains(i - 1)) ||
                    (i + 1 < n && set.contains(i + 1))) {
                    i++;
                    continue;
                }

                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {

                        buckets++;
                        set.add(i + 1);
                    
                    i = i + 2; 
                }

                else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {

                        buckets++;
                        set.add(i - 1);
                    
                    i = i + 1;
                }

                else {
                    return -1;
                }
            }
            else {
                i++;
            }
        }
        return buckets;
    }
}
