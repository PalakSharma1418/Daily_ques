// Last updated: 8/6/2025, 4:46:14 PM
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder s = new StringBuilder();
        while(a>0 || b>0){
            // a jyada ho
            if(a>b && b!=0){
                s.append("aab");
                a-=2;
                b--;
            }
            // b jyada
            else if(b>a && a!=0){
                s.append("bba");
                b-=2;
                a--;
            }
            else if(a>0){
                s.append("a");
                a--;
            }
            else{
                s.append("b");
                b--;
            }
        }
        return s.toString();
    }
}