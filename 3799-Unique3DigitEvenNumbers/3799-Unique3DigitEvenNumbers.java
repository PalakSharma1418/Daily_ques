// Last updated: 8/6/2025, 4:41:13 PM
class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> un= new HashSet<>();
        for(int i=0;i<n;i++){
            if(digits[i]==0) continue;
            for(int j=0;j<n;j++){
                if(j==i) continue;
                for(int k=0;k<n;k++){
                    if(k==i||k==j) continue;
                    if(digits[k]%2==0){
                        int no=digits[i]*100+digits[j]*10+digits[k];
                        un.add(no);
                    }
                }
            }
        }
        return un.size();
    }
 
}