# Linked List Frequency

```
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nodes

```java
class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap();
        for(; head != null; head = head.next){
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
        }
        ListNode prev = null,
                 cur = null;
        for(int value: map.values()){
            if(prev == null){
                cur = new ListNode(value);
                prev = cur;
            }else{
                prev.next = new ListNode(value);
                prev = prev.next;
            }
        }
        return cur;
    }
}
```
