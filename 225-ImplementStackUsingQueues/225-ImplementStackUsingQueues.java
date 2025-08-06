// Last updated: 8/6/2025, 4:49:04 PM

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {}

    public void push(int x) {
        q2.offer(x); // step 1
        while (!q1.isEmpty()) {
            q2.offer(q1.poll()); // step 2
        }
        // step 3
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll(); // front of q1 is the top of stack
    }

    public int top() {
        return q1.peek(); // front of q1 is the top of stack
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}


// Queue is just an interface in Java.
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */