```
/**
 * Definition for singly-linked list.
 * public class ListNode {
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
* Time Complexity: O(A+B)
* Space Complexity: O(1)
	* A as length of headA
	* B as length of headB
```
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA,
                 b = headB;
        while(a != b){
            a = (a == null)?headB:a.next;
            b = (b == null)?headA:b.next;
        }
        return a;
    }
}
```