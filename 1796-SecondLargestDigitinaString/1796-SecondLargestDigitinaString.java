// Last updated: 9/26/2025, 1:26:51 PM
class Solution {
    public int secondHighest(String s) {
        int max=-1,sec=-1;
        boolean f=true;
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<='9'){
                if(ch-'0'>max){
                    sec=max;
                    max=ch-'0';
                }
                else if(ch-'0'< max && ch-'0'>sec){
                    sec=ch-'0';
                }
            }
        }  
        return sec;   
    }
}