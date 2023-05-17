# Iterate
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes of linkedlist
```
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head,
                 prev = dummy;
        while(cur != null && cur.next != null){
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
```