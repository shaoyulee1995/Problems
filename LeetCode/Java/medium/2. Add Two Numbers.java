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
        ListNode node = new ListNode(0),
                 real = node;
       
        int carry = 0;
        while(l1 != null || l2 != null){
            int val_1 = (l1!=null)?l1.val:0,
                val_2 = (l2!=null)?l2.val:0;
            int sum = val_1 + val_2 + carry;
            if(sum > 10){
                carry = 1;
            }
            carry = sum / 10;
            ListNode temp = new ListNode(sum%10);
            
            node.next = temp;
            node = node.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            
        }
        if(carry > 0){
            node.next = new ListNode(carry);
        }
        
        return real.next;
    }
}s