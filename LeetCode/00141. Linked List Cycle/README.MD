```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
```
# LinkedList
* Time Complexity: O(N)
* Space Complexity: O(1)
```
public class Solution {
    ListNode fast, slow;
    public boolean hasCycle(ListNode head) {
        fast = slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
```