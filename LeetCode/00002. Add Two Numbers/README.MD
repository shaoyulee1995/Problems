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
* Time Complexity: O(MAX(L1, L2))
* Space Complexity: O(1)
	* L1 as length of l1
	* L2 as length of l2
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0),
                 head = dummyhead;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = (l1 == null)?0: l1.val,
                val2 = (l2 == null)?0: l2.val;
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum / 10;
            dummyhead.next = node;
            dummyhead = dummyhead.next;
            l1 = (l1 == null)?null:l1.next;
            l2 = (l2 == null)?null:l2.next;
        }
        if(carry != 0){
            dummyhead.next = new ListNode(1);
        }
        return head.next;
    }
}
```