// Last updated: 8/6/2025, 4:40:58 PM
class Solution {
    public int maxSubstrings(String word) {
        int n= word.length();
        List<Integer> [] charind= new ArrayList[26];
        for(int i=0;i<26;i++){
            charind[i]= new ArrayList<>();
            
        }
        for(int i=0;i<n;i++){
            charind[word.charAt(i)-'a'].add(i);
        }
        List<int[]> interval= new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            List<Integer> posi= charind[ch-'a'];
            int t=i+3;
            int idx=Collections.binarySearch(posi,t);
            if(idx<0) idx= -idx-1;
            if(idx<posi.size()){
                int j=posi.get(idx);
                interval.add(new int[]{i,j});
            }
        }
        interval.sort(Comparator.comparingInt(a -> a[1]));
        int c=0;
        int le=-1;
        for(int [] inter:interval){
            if(inter[0]>le){
                c++;
                le=inter[1];
            }
        }
        return c;
    }
}