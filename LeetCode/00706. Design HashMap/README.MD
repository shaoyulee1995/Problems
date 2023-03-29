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
    ListNode[] data;
    public MyHashMap() {
        data = new ListNode[size];
    }
    
    public int hash(int key){
        return (int)((long)key*mult%size);
    }

    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key, value, data[h]);
        data[h] = node;
    }
    
    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        for(; node != null; node = node.next){
            if(node.key == key){
                return node.val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if(node == null){
            return;
        }
        if(node.key == key){
            data[h] = node.next;
        }else{
            for(; node.next != null; node = node.next){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return;
                }
            }
        }
    }
}
class ListNode{
    int key, val;
    ListNode next;
    public ListNode(int key, int val, ListNode next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
```
```
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```