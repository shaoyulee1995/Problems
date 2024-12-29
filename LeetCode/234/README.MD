# Palindrome Linked List

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

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of head
```java
class Solution {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right){
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        if(!res){
            return false;
        }
        left = left.next;
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of head
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,
                 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        ListNode right = reverse(slow),
                 left = head;
        while(right != null){
            if(right.val != left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    ListNode reverse(ListNode node){
        ListNode prev = null,
                 cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of head

```java
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
