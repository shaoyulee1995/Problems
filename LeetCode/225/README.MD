# Implement Stack using Queues
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
    Queue<Integer> queue;
    int topElement;
    public MyStack() {
        queue = new LinkedList();
        topElement = 0;
    }
    
    public void push(int x) {
        queue.offer(x);
        topElement = x;
    }
    
    public int pop() {
        int size = queue.size();
        while(size > 2){
            queue.offer(queue.poll());
            size--;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }
    
    public int top() {
        return topElement;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}    

Your MyStack object will be instantiated and called as such:
MyStack obj = new MyStack();
obj.push(x);
int param_2 = obj.pop();
int param_3 = obj.top();
boolean param_4 = obj.empty();
```