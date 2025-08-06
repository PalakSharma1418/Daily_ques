// Last updated: 8/6/2025, 4:51:43 PM
class Solution {
    public int reverse(int x) { int r;
        long rv=0;
        int sr=(int)Math.pow(-2,31);//minimum range value
        int er=(int)(Math.pow(2,31)-1);//maxmum range value
        while(x!=0){
            r=x%10;
            rv=rv*10+r;
            x=x/10;
        }
        if(rv>=sr && rv<=er){
            return (int)(rv);
        }
        else{
            return 0;
        }
    }
}