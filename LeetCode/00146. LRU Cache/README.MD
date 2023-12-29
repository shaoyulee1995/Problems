# LRU
* get: 
	* Time Complexity: O(1)
* put: 
	* Time Complexity: O(1)
* LRU:
	* Space Complexity: O(N)
        * N as capacity
```
class LRUCache {
    HashMap<Integer, Node> map;
    LinkedListLRU lru;
    int capacity;
    public LRUCache(int capacity) {
        lru = new LinkedListLRU();
        map = new HashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        lru.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            lru.moveToHead(node);
        }else{
            if(map.size() == this.capacity){
                Node removeNode = lru.getTail();
                map.remove(removeNode.key);
                lru.removeTail();
            }
            Node insertedNode = new Node(key, value);
            lru.addToHead(insertedNode);
            map.put(key, insertedNode);
        }
    }

    class LinkedListLRU{
        Node dummyHead, dummyTail;
        public LinkedListLRU(){
            dummyHead = new Node(0, 0);
            dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public void removeTail(){
            Node last = getTail();
            last.prev.next = dummyTail;
            dummyTail.prev = last.prev;
        }

        public Node getTail(){
            return dummyTail.prev;
        }

        public void moveToHead(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToHead(node);
        }

        public void addToHead(Node node){
            Node tmp = dummyHead.next;
            dummyHead.next = node;
            node.next = tmp;
            tmp.prev = node;
            node.prev = dummyHead;
        }
    }

    class Node{
        int key, val;
        Node prev, next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
```
```
Your LRUCache object will be instantiated d called as such:
LRUCache obj = new LRUCache(capacity);
int param_1 = obj.get(key);
obj.put(key,value);
```