# LinkedList
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode current = head;
        dummy.next = current.next;
        while(current != null && current.next != null){
            prev.next = current.next;
            current.next = prev.next.next;
            prev.next.next = current;
            prev = current;
            current = current.next;
        }
        return dummy.next;
        
    }
}
```