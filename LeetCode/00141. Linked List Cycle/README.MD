```
Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
```
# LinkedList
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as nodes in linkedlist
```
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
```