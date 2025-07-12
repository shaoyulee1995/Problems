```java
Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

# Split Linked List in Parts

- Time Complexity: O(N)
- Space Complexity: O(N)
    - N as nodes in list

```java
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = 0;
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        int minSize = size/k,
            remainder = size%k;
        
        ListNode prev = null;
        node = head;
        for(int i = 0; node != null && i < k; i++, remainder--){
            res[i] = node;
            int currentWindowSize = minSize + ((remainder > 0)? 1: 0);
            for(int j = 0; j < currentWindowSize; j++){
                prev = node;
                node = node.next;
            }
            if(prev != null){
                prev.next = null;
            }
        }

        return res;
    }
}
```