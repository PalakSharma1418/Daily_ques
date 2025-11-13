// Last updated: 11/13/2025, 7:54:04 PM
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