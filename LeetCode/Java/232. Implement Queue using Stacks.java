class MyQueue {

    Stack<Integer> s1,
                   s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(s1.size() > 1){
            s2.add(s1.pop());
        }
        int val = s1.pop();
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
        return val;
    }
    
    /** Get the front element. */
    public int peek() {
        while(s1.size() > 1){
            s2.add(s1.pop());
        }
        int val = s1.peek();
        while(!s2.isEmpty()){
            s1.add(s2.pop());
        }
        return val;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (s1.isEmpty());
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