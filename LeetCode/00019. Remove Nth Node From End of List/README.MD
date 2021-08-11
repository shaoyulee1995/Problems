# Two Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
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
```
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), 
                 L = dummy, 
                 R = head;
        dummy.next = head;
        while(n > 0 && R != null){
            R = R.next;
            n--;
        }
        while(R != null){
            R = R.next;
            L = L.next;
        }
        L.next = L.next.next;
        return dummy.next;
    }
}

```