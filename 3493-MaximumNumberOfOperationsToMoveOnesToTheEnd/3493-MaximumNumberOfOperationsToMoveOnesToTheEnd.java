// Last updated: 12/16/2025, 4:03:16 PM
class Solution {
    public int maxOperations(String s) {
        int count=0;
        int total=0;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
                flag=false;
            }else if(flag==false){
                total+=count;
                flag=true;
            }
        }
        return total;
        
    }
}