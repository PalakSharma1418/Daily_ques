// Last updated: 11/15/2025, 4:31:49 PM
class Solution {
    public int scheduleCourse(int[][] courses) {
         Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int currentTime = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            currentTime += duration;
            maxHeap.add(duration);
            if (currentTime > lastDay) {
                int longest = maxHeap.poll(); 
                currentTime -= longest;      
            }
        }
        return maxHeap.size();
    }
}