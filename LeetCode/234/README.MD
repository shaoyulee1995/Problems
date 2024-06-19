# Palindrome Linked List

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

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    public boolean traverse(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
```

# 2 Pointers

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){//for odd length
            slow = slow.next;
        }
        ListNode rightPart = reverse(slow);
        ListNode leftPart = head;
        while(rightPart!=null){
            if(rightPart.val != leftPart.val){
                return false;
            }
            rightPart = rightPart.next;
            leftPart = leftPart.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node){
        ListNode prev, cur, next;
        prev = null;
        cur = node;
        next = node;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

# BFS

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            if(slow.val != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
```
