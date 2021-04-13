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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return  null;
        }
        
        
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy,
                 next = dummy.next;
        
        while(next!=null){
            for(int i = 0; i < k &&next != null; i++){
                stack.push(next);
                next = next.next;
            }
            
            if(stack.size() != k){
                return dummy.next;
            }
            while(stack.size() != 0){
                current.next = stack.pop();
                current = current.next;
            }
            current.next = next;
        }
        
        return dummy.next;
    }
}