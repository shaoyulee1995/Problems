# Merge Nodes in Between Zeros

```java
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
- Space Complexity: O(1)
  - N as length of nodes

```java
class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        if(head == null){
            return head;
        }
        ListNode node = head;
        int sum = 0;
        while(node.val != 0){
            sum += node.val;
            node = node.next;
        }
        head.val = sum;
        head.next = mergeNodes(node);
        return head;
    }
}
```