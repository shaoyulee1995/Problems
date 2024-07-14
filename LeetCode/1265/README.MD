# Print Immutable Linked List in Reverse

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of linkedlist

```
// This is the ImmutableListNode's API interface.
// You should not implement it, or speculate about its implementation.
interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
};

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if(head != null){
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
```
