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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
        ListNode dummy = new ListNode(0),
                 head = dummy;
        for(ListNode node: lists){
            if(node != null) {
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            head.next = pq.poll();
            head = head.next;
            if(head.next != null){
                pq.add(head.next);
            }
        }
        return dummy.next;
    }
}