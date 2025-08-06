// Last updated: 8/6/2025, 4:43:02 PM
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p=0,t=0;
        int n=players.length;
        int m=trainers.length;
        Arrays.sort(trainers);
        Arrays.sort(players);
        while(p<n && t<m){
            if(players[p]<=trainers[t]){
                p++;
            }
            t++;
        }
        return p;
    }
}