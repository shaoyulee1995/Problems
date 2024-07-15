# Count Complete Tree Nodes

```
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes

```java
class Solution {
    public int countNodes(TreeNode root) {
        return (root != null)? 1 + countNodes(root.left) + countNodes(root.right): 0;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as nodes

```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left),
            right = countNodes(root.right);
        return left+right+1;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as nodes

```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = goLeft(root),
            right = goRight(root);
        if(right == left){
            return ((2 << left) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int goLeft(TreeNode root){
        int res = 0;
        while(root.left != null){
            res++;
            root = root.left;
        }
        return res;
    }
    public int goRight(TreeNode root){
        int res = 0;
        while(root.right != null){
            root = root.right;
            res++;
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes

```java
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                res++;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
```
