// Last updated: 12/8/2025, 7:49:45 PM
1class Solution {
2    public List<Integer> replaceNonCoprimes(int[] nums) {
3        List<Integer> stack = new ArrayList<>();
4        
5        for (int num : nums) {
6            while (!stack.isEmpty()) {
7                int top = stack.get(stack.size() - 1);
8                int g = gcd(top, num);
9                if (g == 1) {
10                    break;
11                }
12                // merge top with current num (via LCM)
13                stack.remove(stack.size() - 1);
14                num = (top / g) * num;  // safer LCM
15            }
16            stack.add(num);
17        }
18        
19        return stack;
20    }
21    
22    private int gcd(int a, int b) {
23        if (b == 0) return a;
24        return gcd(b, a % b);
25    }
26}