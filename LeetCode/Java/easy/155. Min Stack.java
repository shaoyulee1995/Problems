class MinStack {
    
    private Node head;
    /** initialize your data structure here. */
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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */