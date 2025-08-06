// Last updated: 8/6/2025, 4:47:27 PM
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] distances = {
            distanceSquared(p1, p2),
            distanceSquared(p1, p3),
            distanceSquared(p1, p4),
            distanceSquared(p2, p3),
            distanceSquared(p2, p4),
            distanceSquared(p3, p4)
        };

        Arrays.sort(distances);
        return distances[0] > 0 &&
               distances[0] == distances[1] &&
               distances[1] == distances[2] &&
               distances[2] == distances[3] &&
               distances[4] == distances[5] &&
               distances[4] == 2 * distances[0];
    }

    private int distanceSquared(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
