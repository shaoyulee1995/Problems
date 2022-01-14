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
* Time Complexity: O(MAX(l1, l2))
* Space Complexity: O(1)
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while(l1!= null || l2 != null){
            int val1 = (l1 == null)?0: l1.val;
            int val2 = (l2 == null)?0: l2.val;
            int sum = val1 + val2 + carry;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }
}
```