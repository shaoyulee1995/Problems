# Stack
* Time Complexity:
	* push: O(1)
	* pop: O(N)
	* peek: O(N)
	* empty: O(1)
* Space Complexity: O(N)
```
class MyQueue {

    Stack<Integer> stackIn, stackOut;
    public MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public void dumpStackIn(){
        if(!stackOut.isEmpty()){
            return;
        }
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }
    
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }
}

Your MyQueue object will be instantiated and called as such:
MyQueue obj = new MyQueue();
obj.push(x);
int param_2 = obj.pop();
int param_3 = obj.peek();
boolean param_4 = obj.empty();
```