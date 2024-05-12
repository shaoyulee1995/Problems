# Design Linked List
# LinkedList
* MyLinkedList: 
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* get
	* Time Complexity: O(N)
	* Space Complexity: O(1)
        * N as number of nodes
* addAtHead
	* Time Complexity: O(N)
	* Space Complexity: O(1)
        * N as number of nodes
* addAtTail
	* Time Complexity: O(N)
	* Space Complexity: O(1)
        * N as number of nodes
* addAtIndex
	* Time Complexity: O(N)
	* Space Complexity: O(1)
        * N as number of nodes
* deleteAtIndex
	* Time Complexity: O(N)
	* Space Complexity: O(1)
        * N as number of nodes
```
class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode node = head;
        for(int i = 0; i <= index; i++){
            node = node.next;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);    
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        size++;
        ListNode node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){
            return;
        }
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        node.next = node.next.next;
    }
}

YoUr MyLinkedList object will be instantiated and called as such:
MyLinkedList obj = new MyLinkedList();
int param_1 = obj.get(index);
obj.addAtHead(val);
obj.addAtTail(val);
obj.addAtIndex(index,val);
obj.deleteAtIndex(index);
```