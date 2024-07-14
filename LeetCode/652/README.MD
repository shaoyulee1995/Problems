# Find Duplicate Subtrees

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

# Post Order Traversal

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes

```java
class Solution{
    HashMap<String, Integer> map = new HashMap();
    LinkedList<TreeNode> res = new LinkedList();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    public String traverse(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = traverse(root.left),
               right = traverse(root.right);
        String path = root.val + "," + left + "," + right;
        int freq = map.getOrDefault(path, 0);
        if(freq == 1){
            res.add(root);
        }
        map.put(path, freq + 1);
        return path;
    }
}
```
