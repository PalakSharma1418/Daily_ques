// Last updated: 2/18/2026, 11:35:42 AM
class Solution {
    static final int MAX_NUM = 10000;
    boolean[] prime = new boolean[MAX_NUM];
    class DijkstraPair {
        int vtx;
        int cost;

        DijkstraPair(int vtx, int cost) {
            this.vtx = vtx;
            this.cost = cost;
        }

        public String toString() {
            return this.vtx + " @ " + this.cost;
        }
    }
    void precomputePrimes() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i < MAX_NUM; i++) {
            if (prime[i]) {
                for (int j = i * i; j < MAX_NUM; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    List<Integer> getNeighbors(int curr) {
        List<Integer> neighbors = new ArrayList<>();
        char[] digits = String.valueOf(curr).toCharArray();

        for (int i = 0; i < digits.length; i++) {
            char original = digits[i];

            // Increment digit
            if (original < '9') {
                digits[i] = (char) (original + 1);
                int val = Integer.parseInt(new String(digits));
                if (!prime[val]) neighbors.add(val);
            }

            // Decrement digit
            if (original > '0') {
                digits[i] = (char) (original - 1);
                int val = Integer.parseInt(new String(digits));
                if (!prime[val]) neighbors.add(val);
            }

            digits[i] = original; // backtrack
        }
        return neighbors;
    }

    public int minOperations(int n, int m) {

        precomputePrimes();

        if (prime[n] || prime[m]) return -1;
        if (n == m) return n;

        PriorityQueue<DijkstraPair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        HashSet<Integer> visited = new HashSet<>();

        pq.add(new DijkstraPair(n, n));

        while (!pq.isEmpty()) {

            // 1. remove
            DijkstraPair rp = pq.poll();

            // 2. ignore
            if (visited.contains(rp.vtx)) {
                continue;
            }

            // 3. mark visited
            visited.add(rp.vtx);

            // 4. self work
            if (rp.vtx == m) {
                return rp.cost;
            }

            // 5. add neighbors
            for (int nbr : getNeighbors(rp.vtx)) {
                if (!visited.contains(nbr)) {
                    pq.add(new DijkstraPair(nbr, rp.cost + nbr));
                }
            }
        }

        return -1;
    }
}

