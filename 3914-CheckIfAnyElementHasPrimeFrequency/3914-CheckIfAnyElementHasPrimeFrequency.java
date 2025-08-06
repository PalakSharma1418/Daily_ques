// Last updated: 8/6/2025, 4:40:47 PM
class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> m= new HashMap<>();
        for(int no: nums){
            m.put(no,m.getOrDefault(no,0)+1);
        }
        for(Integer h: m.keySet()){
            if(isprime(m.get(h))){
                return true;
            }
        }
        return false;
    }
    public boolean isprime(int n){
        if(n<=1) return false;
        if(n==2 || n==3) return true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}