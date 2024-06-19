# Find Elements in a Contaminated Binary Tree

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
```

# PreOrder

- FindElements
  - Time Complexity: O(1)
  - Space Complexity: O(N)
- find
  - Time Complexity: O(1)
  - Space Complexity: O(1)
- preOrder
  - Time Complexity: O(N)
  - Space Complexity: O(1)

```
class FindElements {
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet();
        preOrder(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    public void preOrder(TreeNode node, int p_value){
        if(node == null){
            return;
        }
        node.val = p_value;
        set.add(node.val);
        preOrder(node.left, 2*p_value+1);
        preOrder(node.right, 2*p_value+2);
    }
}
```

```
/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
```
