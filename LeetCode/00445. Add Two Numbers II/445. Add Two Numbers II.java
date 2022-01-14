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