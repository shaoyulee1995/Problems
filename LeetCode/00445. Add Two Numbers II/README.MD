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
# Stack
* Time Complexity: O(Max(L1, L2))
* Space Complexity: O(Max(L1, L2))
	* L1 as length of l1
	* L2 as length of l2
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(),
                       s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode list = new ListNode(0);
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int digit1 = (s1.isEmpty())?0: s1.pop(),
                digit2 = (s2.isEmpty())?0: s2.pop();
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            list.val = sum % 10;
            ListNode head = new ListNode(carry);
            head.next = list;
            list = head;
        }
        if(carry != 0){
            ListNode temp = new ListNode(1);
            temp.next = list;
            list = temp;
        }
        return list.next;
    }
}
```
# LinkedList
* Time Complexity: O(Max(L1, L2))
* Space Complexity: O(Max(L1, L2))
	* L1 as length of l1
	* L2 as length of l2
```
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reserveLinkedList(l1);
        l2 = reserveLinkedList(l2);
        return add(l1, l2);
    }
    public ListNode add(ListNode l1, ListNode l2) {
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
        return reserveLinkedList(head.next);
    }
    public ListNode reserveLinkedList(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
```