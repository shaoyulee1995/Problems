# Merge Two Sorted Lists

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

- Time Complexity: O(Min(N, M))
- Space Complexity: O(1)
  - N as length of l1
  - M as length of l2

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
```

- Time Complexity: O(Min(N, M))
- Space Complexity: O(1)
  - N as length of l1
  - M as length of l2

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(),
                 cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
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
