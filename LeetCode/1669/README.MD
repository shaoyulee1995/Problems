# Merge In Between Linked Lists

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
```

# LinkedList

- Time Complexity: O(L1 + L2)
- Space Complexity: O(1)
  - L1 is length of list1
  - L2 is length of list2

```java
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        for(int i = 1; i < a; i++){
            start = start.next;
        }
        ListNode end = start;
        for(int i= start.val; i <= b; i++){
            end = end.next;
        }
        start.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = end;
        return list1;
    }
}
```
