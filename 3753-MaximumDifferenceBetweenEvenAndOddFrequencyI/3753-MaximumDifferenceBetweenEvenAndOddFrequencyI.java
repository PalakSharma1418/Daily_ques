// Last updated: 8/6/2025, 4:41:17 PM
class Solution {
    public int maxDifference(String s) {
        int [] freq= new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        // int e=Integer.MAX_VALUE,o=Integer.MIN_VALUE;
        // for(int j=0;j<26;j++){
        //     if(freq[j]%2==0){
        //         e=Math.min(freq[j],e);
        //     }
        //     else{
        //         o=Math.max(freq[j],o);
        //     }
        // }
        int max=Integer.MIN_VALUE;
        // for(int i=0;i<s.length()-1;i++){
        //     if(s.charAt(i)!=s.charAt(i+1)){
        //         if(freq[s.charAt(i)-'a']%2!=0 && freq[s.charAt(i+1)-'a']%2==0){
        //             max=Math.max(max,(freq[s.charAt(i)-'a']-freq[s.charAt(i+1)-'a']));
        //         }
        //         else if(freq[s.charAt(i)-'a']%2==0 && freq[s.charAt(i+1)-'a']%2!=0){
        //             max=Math.max(max,(freq[s.charAt(i+1)-'a']-freq[s.charAt(i)-'a']));
        //         }
        //     }
        // }
        List<Integer> e= new ArrayList<>();
        List<Integer> o= new ArrayList<>();
        for(int i=0;i<26;i++){
            if(freq[i]>0 && freq[i]%2==0){
                e.add(freq[i]);
            }
            else if(freq[i]>0 && freq[i]%2!=0){
                o.add(freq[i]);
            }
        }
        for(int i=0;i<o.size();i++){
            for(int j=0;j<e.size();j++){
                int d= o.get(i)-e.get(j);
                max=Math.max(max,d);
            }
        }
        return max;
    }
}