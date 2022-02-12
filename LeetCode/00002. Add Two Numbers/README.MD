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
        ListNode head = null,
                 dummy = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val_1 = (l1==null)?0:l1.val,
                val_2 = (l2==null)?0:l2.val;
            int sum = val_1 + val_2 + carry;
            ListNode node = new ListNode(sum%10);
            if(head == null){
                head = dummy = node;
            }else{
                head.next = node;
                head = head.next;
            }
            carry = sum/10;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
        }
        if(carry != 0){
            head.next = new ListNode(1);
        }
        return dummy;
    }
}
```