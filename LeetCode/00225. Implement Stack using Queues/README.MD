# Queue Array
* Space Complexity: O(N)

* push
	* Time Complexity: O(1)
* pop
	* Time Complexity: O(N)
* top
	* Time Complexity: O(1)
* empty
	* Time Complexity: O(1)
```
class MyStack {

    Queue<Integer> q1;
    int top_element  = 0;
    public MyStack() {
        q1 = new LinkedList();
    }
    
    public void push(int x) {
        top_element = x;
        q1.offer(x);
    }
    
    public int pop() {
        int size = q1.size();
        while(size > 2){
            q1.offer(q1.poll());
            size--;
        }
        top_element = q1.peek();
        q1.offer(q1.poll());
        return q1.poll();
    }
    
    public int top() {
        return top_element;    
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```