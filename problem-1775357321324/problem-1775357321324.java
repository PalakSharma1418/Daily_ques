// Last updated: 4/5/2026, 8:18:41 AM
1class Solution {
2    public List<Integer> findGoodIntegers(int n) {
3        int l = (int)Math.cbrt(n);
4        HashMap<Integer , Integer> map = new HashMap<>();
5        for(int i = 1 ; i<= l ; i++){
6            int c1 = i*i*i ;//Math.pow(i,3);
7            for(int j = i ; j<= l ; j++){
8                int c2 = j*j*j ; //Math.pow(j,3);
9                int sum = c1+c2;
10                if(c1 > n - c2) break;
11                map.put(sum , map.getOrDefault(sum,0)+1);
12            }
13        }
14
15        List<Integer> res = new ArrayList<>();
16        for(int key : map.keySet()){
17            if(map.get(key) >= 2){
18                res.add(key);
19            }
20        }
21    
22    Collections.sort(res);
23    return res;
24    }
25}