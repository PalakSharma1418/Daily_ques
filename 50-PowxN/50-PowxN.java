// Last updated: 8/6/2025, 4:50:53 PM
class Solution {
  public double myPow(double x, int n) {
        
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        
        double pow = 1;
        
        while(n != 0){
            if((n % 2) != 0){   // ((n & 1) != 0)
                pow *= x;
            } 
                
            x *= x;
            n = n/2; //n>>>=1
            
        }
        
        return pow;
    }
}