# LRU Cache

- get:
  - Time Complexity: O(1)
- put:
  - Time Complexity: O(1)
- LRU:
  - Space Complexity: O(N) \* N as capacity

```java
class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class LruLinkedListed{
        Node dummyHead, dummyTail;

        public LruLinkedListed(){
            dummyHead = new Node();
            dummyTail = new Node();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public void removeTail(){
            Node originalTail = getTail();
            this.disconnectedNode(originalTail);
        }

        public Node getTail(){
            return dummyTail.prev;
        }

        public void moveNodeToHead(Node node){
            disconnectedNode(node);
            insertAtHead(node);
        }

        public void insertAtHead(Node node){
            Node originalHead = dummyHead.next;
            node.next = originalHead;
            originalHead.prev = node;
            dummyHead.next = node;
            node.prev = dummyHead;
        }

        public void disconnectedNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    LruLinkedListed lru;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new LruLinkedListed();
        map = new HashMap();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        lru.moveNodeToHead(node);
        map.put(key, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            if(capacity == map.size()){
                Node tail = lru.getTail();
                lru.removeTail();
                map.remove(tail.key);
            }
            Node insertNode = new Node(key, value);
            lru.insertAtHead(insertNode);
            map.put(key, insertNode);
        }else{
            node.value = value;
            lru.moveNodeToHead(node);
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
