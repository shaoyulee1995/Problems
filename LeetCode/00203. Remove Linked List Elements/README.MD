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
 
# Iteration
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as number of nodes
```
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}
```

# Recursion
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as number of nodes
```
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode next = removeElements(head.next, val);
        if(head.val==val){
            return next;
        }
        head.next = next;
        return head;
    }
}
```