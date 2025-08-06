// Last updated: 8/6/2025, 4:43:57 PM
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(flip(answerKey,k,'F'),flip(answerKey,k,'T'));
    }
    public int flip(String s,int k,char ch){
        int left=0;
        int maxlen=0;
        int c=0;
        for(int right=0;right<s.length();right++){
            if(s.charAt(right)!=ch) c++;
            //shrink
            while(c>k){
                if(s.charAt(left)!=ch) c--;//flip bala hai
                left++;
            }
            //ans
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}