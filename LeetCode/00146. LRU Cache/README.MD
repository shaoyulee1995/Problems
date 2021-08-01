# LRU
* Time Complexity: O(1)
* Space Complexity: O(1)
```
class LRUCache {
    private LinkedNodeList list;
    private HashMap<Integer, Node> map;
    private Integer cap;
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        list = new LinkedNodeList();
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        list.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            list.moveToHead(node);
            node.val = value;
        }else{
            Node newNode = new Node(key,value);
            if(map.size() == cap){
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}
```
```
class LinkedNodeList{
    Node dummyHead, dummyTail;

    LinkedNodeList(){
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }
    void addToHead(Node node){
        Node tmp = dummyHead.next;
        dummyHead.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = dummyHead;
    }
    void removeTail(){
        Node temp = dummyTail.prev.prev;
        temp.next = dummyTail;
        dummyTail.prev = temp;
    }
    Node getTail(){
        return dummyTail.prev;
    }
}
```
```
class Node{
    int key, val;
    Node next, prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
```
```
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```