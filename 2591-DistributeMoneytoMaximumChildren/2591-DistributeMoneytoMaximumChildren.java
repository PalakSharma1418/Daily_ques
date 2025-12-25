// Last updated: 12/25/2025, 4:12:20 PM
1class Solution {
2    public int distMoney(int money, int children) {
3       if(money < children) return -1;
4        money -= children;
5
6        int res = 0;
7        while(money >= 7 && children > 0) {
8            money -= 7;
9            res++;
10            children--;
11        }
12        if(res==0)
13           return res;
14        else
15        {
16            if(children==0 && money>0)
17               res-=1;
18            if(children==1 && money==3)
19               res-=1;
20        }
21        return res;
22    }
23}
24