# Delete Node in a Linked List

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
```

# LinkedList

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N length of linkedlist

```
class Solution {
    public void deleteNode(ListNode node) {
        while(node.next != null){
            node.val = node.next.val;
            if(node.next.next == null){
                node.next = null;
            }else{
                node = node.next;
            }
        }
    }
}
```
