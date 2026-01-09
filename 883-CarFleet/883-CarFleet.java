// Last updated: 1/9/2026, 10:58:52 AM
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i]; 
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        int fleets = 0;
        double lastTime = 0.0;
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
    
            if (time > lastTime) {
                fleets++;
                lastTime = time; 
            }
        }
        return fleets;
    }
}