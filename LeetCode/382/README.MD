# Linked List Random Node

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

# ArrayList

- Time Complexity: O(1)
- Space Complexity: O(N)
  - N as nodes

```java
class Solution{
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int count = 0;
        ListNode candidate = head;
        for(ListNode node = head; node != null; node = node.next){
            if(rand.nextInt(count+1) == count){
                candidate = node;
            }
            count++;
        }
        return candidate.val;
    }
}
```

```
Your Solution object will be instantiated and called as such:
Solution obj = new Solution(head);
int param_1 = obj.getRandom();
```
