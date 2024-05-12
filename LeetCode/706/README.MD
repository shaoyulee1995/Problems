# Design HashMap
# LinkedList
* MyHashMap: 
	* Time Complexity: O(1)
	* Space Complexity: O(N)
		* N as size
* hash
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* put
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* get
	* Time Complexity: O(1)
	* Space Complexity: O(1)
* remove
	* Time Complexity: O(1)
	* Space Complexity: O(1)
```
class MyHashMap {
    final int size = 19997;
    final int mult = 12582917;
    Node[] list;
    public MyHashMap() {
        list = new Node[size];
    }

    public int getHash(int key){
        return (int)((long)key*mult%size);
    }
    
    public void put(int key, int value) {
        remove(key);
        int hashIndex = getHash(key);
        Node node = new Node(key, value, list[hashIndex]);
        list[hashIndex] = node;
    }
    
    public int get(int key) {
        int hashIndex = getHash(key);
        Node node = list[hashIndex];
        for(; node != null; node = node.next){
            if(node.key == key){
                return node.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashIndex = getHash(key);
        Node node = list[hashIndex];
        if(node == null){
            return;
        }
        if(node.key == key){
            list[hashIndex] = node.next;
        }else{
            for(; node.next != null; node = node.next){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return;
                }
            }
        }
    }
    class Node{
        Node next;
        int val, key;
        public Node(int key, int val, Node next){
            this.next = next;
            this.val = val;
            this.key = key;
        }
    }
}
```
```
Your MyHashMap object will be instantiated and called as such:
MyHashMap obj = new MyHashMap();
obj.put(key,value);
int param_2 = obj.get(key);
obj.remove(key);
```