// Last updated: 1/9/2026, 10:57:56 AM
import java.util.*;

class Solution {
    private static final int LIMIT = 20000;
    private static final int GRID = 1_000_000;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(encode(b[0], b[1]));
        }
        
        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }
    
    private boolean bfs(int[] start, int[] finish, Set<Long> blocked) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(encode(start[0], start[1]));
        
        while (!queue.isEmpty() && visited.size() <= LIMIT) {
            int[] curr = queue.poll();
            
            if (curr[0] == finish[0] && curr[1] == finish[1]) {
                return true;
            }
            
            for (int[] d : dirs) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                
                if (nx >= 0 && ny >= 0 && nx < GRID && ny < GRID) {
                    long key = encode(nx, ny);
                    if (!blocked.contains(key) && !visited.contains(key)) {
                        visited.add(key);
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        // If we escaped the possible enclosure
        return visited.size() > LIMIT;
    }
    
    private long encode(int x, int y) {
        return ((long)x << 20) | y;
    }
}
