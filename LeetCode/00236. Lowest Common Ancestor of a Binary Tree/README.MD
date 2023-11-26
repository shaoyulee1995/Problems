```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
```
# Recursion
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as nodes in tree
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q),
                 right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
}
```
# Iteration
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes in tree
```
class Solution {
    HashMap<TreeNode, TreeNode> parentMap = new HashMap();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        dfs(root, null);    
        Set<TreeNode> ancestorFromP = new HashSet();
        while(p != null){
            ancestorFromP.add(p);
            p = parentMap.get(p);
        }
        while(!ancestorFromP.contains(q)){
            q = parentMap.get(q);
        }
        return q;
    }

    public void dfs(TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        parentMap.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
```