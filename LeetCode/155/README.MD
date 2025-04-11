# Min Stack

```
Your MinStack object will be instantiated and called as such:
MinStack obj = new MinStack();
obj.push(val);
obj.pop();
int param_3 = obj.top();
int param_4 = obj.getMin();
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nodes

```java
class MinStack {

    private class Node{
        private int data, min;
        Node next;

        public Node(int data, int min){
            this(data, min, null);
        }
        public Node(int data, int min, Node next){
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node head;
    public MinStack() {
    }

    public void push(int val) {
        if(head == null){
            head = new Node(val, val);
        }else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}
```
