// Last updated: 8/6/2025, 4:48:58 PM
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        s1.push(x); // Add to input stack
    }

    public int pop() {
        shiftStacks();
        return s2.pop();
    }

    public int peek() {
        shiftStacks();
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Helper: move elements from s1 to s2 if s2 is empty
    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop()); // reverse order
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */