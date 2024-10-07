# Next Greater Node In Linked List

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
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack();
        for(int i = list.size() - 1; i >= 0; i--){
            while(!stack.isEmpty() && list.get(i) >= stack.peek()){
                stack.pop();
            }
            res[i] = (stack.isEmpty())? 0: stack.peek();
            stack.push(list.get(i));
        }
        return res;
    }
}
```
