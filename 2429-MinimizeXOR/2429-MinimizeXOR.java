// Last updated: 1/21/2026, 12:37:08 PM
1class Solution {
2    public int minimizeXor(int num1, int num2) {
3        return find_x(num1,num2);
4    }
5    public static int find_x(int num1 , int num2){
6        int set_bit=0;
7        while(num2>0){
8            if((num2&1)!=0){ //module
9                set_bit++;
10            }
11            num2>>=1; //bit ko side shift kara
12        }
13        
14        int x =0;
15        // 32 bit k hi hota hai
16        for(int i =30 ; i>=0 ; i--){
17            int mask = (1<<i);
18            if((num1&mask)!=0){
19                x|=mask;
20                set_bit--;
21                if(set_bit==0) return x;
22            }
23        }
24
25        for(int i =0; i<=30 ; i++){
26            int mask = (1<<i);
27            if((num1&mask)==0){
28                x|=mask;
29                set_bit--;
30                if(set_bit==0) return x;
31            }
32        }
33
34        return x;
35    }
36}