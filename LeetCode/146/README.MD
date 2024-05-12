# LRU Cache
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
    LRU_LinkedList lru;
    HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        lru = new LRU_LinkedList();
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
            if(map.size() == capacity){
                Node tail = lru.getTail();
                lru.removeTail();
                map.remove(tail.key);
            }
            node = new Node(key, value);
            lru.addToHead(node);
            map.put(key, node);
        }
    }

    class LRU_LinkedList{
        Node dummyHead, dummyTail;

        public LRU_LinkedList(){
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public void removeTail(){
            Node tail = getTail();
            tail.prev.next = dummyTail;
            dummyTail.prev = tail.prev;
        }
        
        public Node getTail(){
            return dummyTail.prev;
        }

        public void addToHead(Node node){
            Node srcHead = dummyHead.next;
            node.next = srcHead;
            srcHead.prev = node;
            dummyHead.next = node;
            node.prev = dummyHead;
        }

        public void moveToHead(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToHead(node);
        }
    }
    
    class Node{
        Node prev, next;
        int key, val;
        public Node(){}
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