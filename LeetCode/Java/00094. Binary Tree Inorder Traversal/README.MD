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

# Recursion
* Time Complexity: O(N)
* Space Complexity
	* worst: O(N)
	* average: O(log(N))

```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        inorderTraversal(root, list);
        return list;
    }
    private void inorderTraversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}
```
# Iterative
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
```

# Thread Binary Tree(Morris Traversal)
* Time Complexity: O(N)
* Space Complexity: O(N)

```
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }  
            }else{
                list.add(cur.val);
                cur = cur.right;
            }          
        }
        return list;
    }
}
```