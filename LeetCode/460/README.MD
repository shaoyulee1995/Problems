# LFU Cache

- Time Complexity: O(1)
- Space Complexity: O(N)

```java
class LFUCache {
    final int capacity;
    int size, minFreq;
    HashMap<Integer, Node> cache;
    HashMap<Integer, doubleLinkedList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        cache = new HashMap();
        freqMap = new HashMap();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        updateNode(node);
        return node.val;
    }

    public void updateNode(Node node){
        int freq = node.freq;
        doubleLinkedList list = freqMap.get(freq);
        list.removeNode(node);
        if(freq == minFreq && list.size == 0){
            minFreq++;
        }
        node.freq++;
        doubleLinkedList newlist = freqMap.getOrDefault(node.freq, new doubleLinkedList());
        newlist.addNodeToHead(node);
        freqMap.put(node.freq, newlist);
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            updateNode(node);
        }else{
            size++;
            if(size > capacity){
                doubleLinkedList list = freqMap.get(minFreq);
                Node deleteNode = list.removeTail();
                cache.remove(deleteNode.key);
                size--;
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            doubleLinkedList newlist = freqMap.getOrDefault(1, new doubleLinkedList());
            newlist.addNodeToHead(newNode);
            freqMap.put(1, newlist);
            cache.put(key, newNode);
        }
    }
}
```

```java
class Node{
    int key, val, freq;
    Node prev, next;
    public Node(int key, int val){
        prev = null;
        next = null;
        freq = 1;
        this.key = key;
        this.val = val;
    }
}
```

```java
class doubleLinkedList{
    Node head, tail;
    int size;
    public doubleLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addNodeToHead(Node node){
        Node oldHead = head.next;
        node.next = oldHead;
        node.prev = head;
        head.next = node;
        oldHead.prev = node;
        size++;
    }
    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
    public Node removeTail(){
        if(size > 0){
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
        return null;
    }
}
```

```
Your LFUCache object will be instantiated and called as such:
LFUCache obj = new LFUCache(capacity);
int param_1 = obj.get(key);
obj.put(key,value);
```
