# Linked List Cycle II
```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
```
# LinkedList
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as number of ListNode
```
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }        
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```
# Set
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as number of ListNode
```
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
```