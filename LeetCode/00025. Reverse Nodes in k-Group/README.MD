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

## Solution 1
```
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode a, b;
        a = b = head;
        for(int i = 0; i < k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public ListNode reverse(ListNode a, ListNode b){
        ListNode prev, cur, next;
        prev = null;
        cur = a;
        next = a;
        while(cur != b){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
```

## Solution 2
```
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0),
                 begin = dummy;
        dummy.next = head;
        
        int cnt = 0;
        while(head != null){
            cnt++;
            
            if(cnt % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    } 
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode prev = start,
                 current = start.next,
                 first = current;
        while(current != end){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start.next = prev;
        first.next = current;
        return first;
    }
}
```

# BFS
```
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return  null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy,
                 next = dummy.next;
        while(next!=null){
            for(int i = 0; i < k &&next != null; i++){
                stack.push(next);
                next = next.next;
            }
            if(stack.size() != k){
                return dummy.next;
            }
            while(stack.size() != 0){
                current.next = stack.pop();
                current = current.next;
            }
            current.next = next;
        }
        return dummy.next;
    }
}

```