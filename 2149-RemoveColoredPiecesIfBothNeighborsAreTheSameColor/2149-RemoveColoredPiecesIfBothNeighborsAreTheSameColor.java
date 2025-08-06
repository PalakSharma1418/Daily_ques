// Last updated: 8/6/2025, 4:43:56 PM
class Solution {
    public boolean winnerOfGame(String colors) {
        int movesA = 0;
        int movesB = 0;

        int continousA = 0;
        int continousB = 0;

        for (char c : colors.toCharArray()) {
            if (c == 'A') {
                continousA++;
                continousB = 0;
                if (continousA > 2) {
                    movesA++;
                }
            } else {
                continousB++;
                continousA = 0;
                if (continousB > 2) {
                    movesB++;
                }
            }
        }

        return movesA > movesB;
    }
}