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
        ListNode slow, fast;
        fast = slow = head;
        while(n-->0){
            fast = fast.next;
        }
        
        if(fast == null){
            return head.next;
        }
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```