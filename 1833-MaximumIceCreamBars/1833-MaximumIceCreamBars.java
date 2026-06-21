// Last updated: 6/21/2026, 1:21:01 PM
1class Solution {
2    public int maxIceCream(int[] costs, int coin) {
3        Arrays.sort(costs);
4        if(costs[0]>coin){
5            return 0;
6        }
7        int ans=0;
8        for(int i=0;i<costs.length ; i++){
9            if(costs[i]<= coin){
10                ans++;
11                coin-=costs[i];
12            }else{
13                break;
14            }
15        }
16        return ans;
17    }
18}