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
# InOrder
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as number of nodes in root1 tree
	* M as number of nodes in root2 tree
```
class Solution {
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