```
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```
# Recursion
* Time Complexity: O(Min(N, M))
* Space Complexity: O(1)
    * N as length of l1
    * M as length of l2
```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```
# Iteration
* Time Complexity: O(Min(N, M))
* Space Complexity: O(1)
    * N as length of l1
    * M as length of l2
```
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(),
                 cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2. val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null)? list2: list1;
        
        return dummy.next;
    }
}
```