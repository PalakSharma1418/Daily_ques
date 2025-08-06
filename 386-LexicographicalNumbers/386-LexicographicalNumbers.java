// Last updated: 8/6/2025, 4:48:19 PM
class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> ll= new ArrayList<>();
        if(n==1){
            ll.add(1);
            return ll;
        }
        if(n==2){
            ll.add(1);
            ll.add(2);
            return ll;
        }
        print(n,0,ll);
        return ll;
    }
    public static void print(int  n,int curr,List<Integer> ll){
        if(curr>n){
            return;
        }
        if(curr !=0 ){
            // System.out.println(curr);
            ll.add(curr);
        }
        int i=0;
        if(curr==0){
            i=1;
        }
        for(;i<=9;i++){
            print(n, curr*10+i,ll);
        }
    }
}