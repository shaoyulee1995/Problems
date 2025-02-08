# Copy List with Random Pointer

```java
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of nodes in the linked list

```java
class Solution {

    public Node copyRandomList(Node head) {
        Node current = head,
             next;
        while(current != null){
            next = current.next;
            Node copyNode = new Node(current.val);
            copyNode.next = next;
            current.next = copyNode;
            current = next;
        }

        current = head;
        while(current != null){
            next = current.next.next;
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = next;
        }

        Node dummyHead = new Node(0),
             copyCurrent = dummyHead,
             copy;
        current = head;
        while(current != null){
            next = current.next.next;

            copy = current.next;
            copyCurrent.next = copy;
            copyCurrent = copy;

            current.next = next;
            current = next;
        }

        return dummyHead.next;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the number of nodes in the linked list

```java
class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap();
        for(Node node = head; node != null; node = node.next){
            map.put(node, new Node(node.val));
        }
        for(Node node = head; node != null; node = node.next){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }
}
```
