# All Elements in Two Binary Search Trees

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

- Time Complexity: O(ClogC)
- Space Complexity: O(C)
  - N as number of nodes in root1 tree
  - M as number of nodes in root2 tree
  - C as N + M

```java
class Solution{
    List<Integer> list = new ArrayList();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);
        Collections.sort(list);
        return list;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
```

# Iterative

- Time Complexity: O(MAX(N, M))
- Space Complexity: O(MAX(N, M))
  - N as number of nodes in root1 tree
  - M as number of nodes in root2 tree

```java
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack(),
                        stack2 = new Stack();
        List<Integer> res = new ArrayList();
        while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                stack2.push(root2);
                root2 = root2.left;
            }
            if(stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val < stack2.peek().val)){
                root1 = stack1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = stack2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
```
