// Last updated: 1/9/2026, 10:58:25 AM
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells==null || cells.length==0 || N<=0) return cells; 
        boolean hasCycle = false; 
        int cycle = 0; 
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ 
                set.add(key);
                cycle++;
            }
            else{
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if(hasCycle){
            N = N%cycle;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
         
        return cells; 
    }
    
    public int[] nextDay(int [] arr){
        int[] tem = new int[8];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i-1]==arr[i+1]){
                tem[i]=1;
            }
        }
        return tem;
    } 
}