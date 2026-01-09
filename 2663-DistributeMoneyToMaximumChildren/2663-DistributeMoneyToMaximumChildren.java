// Last updated: 1/9/2026, 10:53:56 AM
class Solution {
    public int distMoney(int money, int children) {
       if(money < children) return -1;
        money -= children;

        int res = 0;
        while(money >= 7 && children > 0) {
            money -= 7;
            res++;
            children--;
        }
        if(res==0)
           return res;
        else
        {
            if(children==0 && money>0)
               res-=1;
            if(children==1 && money==3)
               res-=1;
        }
        return res;
    }
}
