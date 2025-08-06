// Last updated: 8/6/2025, 4:47:05 PM
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed = false;
            // collision condition: last asteroid is positive and new one is negative
            while(!stack.isEmpty() && stack.peek()>0 && asteroid<0){
                if(Math.abs(stack.peek()) < Math.abs(asteroid)){
                    stack.pop();
                    continue;// kyuki current destory nhi hua hai so continue
                }else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                //current asteroid is destroyed
                destroyed = true;
                break;
            }
            if(!destroyed){
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
