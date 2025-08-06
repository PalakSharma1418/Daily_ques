// Last updated: 8/6/2025, 4:49:32 PM
class MinStack {
    public List<Integer> min = new ArrayList<>();
    public List<Integer> stack = new ArrayList<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        if(min.isEmpty() || min.get(min.size()-1) >= val) {
            min.add(val);
        }

    }
    
    public void pop() {
        int popEle = stack.remove(stack.size()-1);
        if(!min.isEmpty() && popEle == min.get(min.size()-1)) {
            min.remove(min.size()-1);
        }
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */