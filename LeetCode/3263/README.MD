# Convert Doubly Linked List to Array I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of list

```java
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
```
```java
class Solution {
    public int[] toArray(Node head) {
        List<Integer> res = new ArrayList();
        while(head != null){
            res.add(head.val);
            head = head.next;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```