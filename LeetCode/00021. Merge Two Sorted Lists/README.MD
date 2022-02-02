```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
```

# LinkedList
* Time Complexity: O(N+M) where N is the length of l1 and M is the length of l2
* Space Complexity: O(1)

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

# Solution 2

```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode merge = new ListNode(),
                 temp = merge;
        while(l1!=null && l2!= null){
           if(l1.val < l2.val){
               temp.next = l1;
               temp = temp.next;
               l1 = l1.next;
           }else{
               temp.next = l2;
               temp = temp.next;
               l2 = l2.next;
           }
        }
        while(l1!=null){
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        
        while(l2!= null){
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        
        return merge.next;
    }
}
```