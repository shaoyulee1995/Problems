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
        ListNode dummy = new ListNode(0),
                 begin = dummy;
        dummy.next = head;
        
        int cnt = 0;
        while(head != null){
            cnt++;
            
            if(cnt % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        
        
        return dummy.next;
    } 
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start,
                 current = start.next,
                 first = current;
        while(current != end){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start.next = prev;
        first.next = current;
        return first;
        
    }
}