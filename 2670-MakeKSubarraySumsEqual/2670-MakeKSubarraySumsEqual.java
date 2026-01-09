// Last updated: 1/9/2026, 10:53:53 AM
class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            List<Integer> sameValue = new ArrayList<>();
            sameValue.add(arr[i]);
            int next = (i + k) % n;        
            while (next != i) { 
                visited[next] = true;
                sameValue.add(arr[next]);
                next = (next + k) % n;
            }

            Collections.sort(sameValue);
            int median = sameValue.get(sameValue.size() / 2);
            
            for (Integer integer : sameValue) {
                total += Math.abs(integer - median);
            }

        }
        return total;
    }
}