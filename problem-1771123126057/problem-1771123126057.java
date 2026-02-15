// Last updated: 2/15/2026, 8:08:46 AM
1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        HashMap<Integer,Integer> map = new HashMap<>();
4        for(int x : nums){
5            map.put(x,map.getOrDefault(x,0)+1);
6        }
7        HashMap<Integer,Integer> fre = new HashMap<>();
8        for(int key : map.keySet()){
9            int f= map.get(key);
10            fre.put(f,fre.getOrDefault(f,0)+1);
11        }
12
13        // for(int c : fre.keySet()){
14        //     if(fre.get(c)==1){
15        //         return
16        //     }
17        // }
18        for(int x: nums){
19            int frq = map.get(x);
20            if(fre.get(frq)==1){
21                return x;
22            }
23        }
24        return -1;
25    }
26}