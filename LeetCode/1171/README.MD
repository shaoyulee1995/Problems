# Remove Zero Sum Consecutive Nodes from Linked List

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

# PreSum, HashMap

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in list

```java
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap();
        int sum = 0;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        for(ListNode node = preHead; node != null; node = node.next){
            sum += node.val;
            map.put(sum, node);
        }
        sum = 0;
        for(ListNode node = preHead; node != null; node = node.next){
            sum += node.val;
            node.next = map.get(sum).next;
        }
        return preHead.next;
    }
}
```
