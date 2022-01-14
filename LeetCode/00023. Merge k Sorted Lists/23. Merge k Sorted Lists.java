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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }
    private ListNode sort(ListNode[] lists, int start, int end){
        if(start >= end){
            return lists[start];
        }
        int mid = start + (end - start)/2;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid + 1, end);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1,l2.next);
        return l2;
    }
}