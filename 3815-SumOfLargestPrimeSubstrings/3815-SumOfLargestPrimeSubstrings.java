// Last updated: 8/6/2025, 4:41:07 PM
class Solution {
    public long sumOfLargestPrimes(String s) {
        long su=0;
        // substring
        int n=s.length();
        Set<Long> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
               String ss=s.substring(i,j).replaceFirst("^0","");
                if(ss.isEmpty()) continue;
                long no= Long.parseLong(ss);
                if(valid(no)) set.add(no);
            }
        }
        List<Long> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for(int i=0;i<Math.min(3,list.size());i++)
            su+=list.get(i);
        return su;
    }
    public boolean valid(long n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        int s= (int) Math.sqrt(n);
        for(int i=3;i<=s;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}