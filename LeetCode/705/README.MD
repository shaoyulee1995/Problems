# Design HashSet

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as the maximum number of elements in the hash set

```java
class MyHashSet {
    boolean[] arr;
    int size;
    public MyHashSet() {
        size = (int)1e6+1;
        arr = new boolean[size];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as the maximum number of elements in the hash set

```java
class Bucket{
    LinkedList<Integer> list;
    public Bucket(){
        list = new LinkedList();
    }

    public void add(int key){
        if(!list.contains(key)){
          list.addFirst(key);
        }
    }

    public void remove(int key){
        int index = list.indexOf(key);
        if(index != -1){
          list.remove(index);
        }
    }
    public boolean exist(int key){
        return list.contains(key);
    }
}
class MyHashSet {
    int size;
    Bucket[] bucket;
    public MyHashSet() {
        size = 769;
        bucket = new Bucket[size];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new Bucket();
        }
    }
    
    public int getHash(int key){
        return key%size;
    }

    public void add(int key) {
        int index = getHash(key);
        bucket[index].add(key);
    }
    
    public void remove(int key) {
        int index = getHash(key);
        bucket[index].remove(key);
    }
    
    public boolean contains(int key) {
        int index = getHash(key);
        return bucket[index].exist(key);
    }
}
```