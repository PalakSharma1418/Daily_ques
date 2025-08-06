// Last updated: 8/6/2025, 4:46:53 PM
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx>sx && ty>sy){
            if(tx>ty){
                tx%=ty;
            }
            else{
                ty%=tx;
            }
        }
        if(sx==tx && ty>=sy){
            return (ty-sy)%tx==0;
        }
        else if(sy==ty && tx>=sx){
             return (tx-sx)%ty==0;
        }
        return false;
    }
}