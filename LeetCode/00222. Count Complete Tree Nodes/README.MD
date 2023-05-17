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
* Space Complexity: O(1)
	* N as nodes
```
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left),
            right =countNodes(root.right);
        return 1 + left + right;
    }
}
```
# Recursion 
* Time Complexity: O(log(N))
* Space Complexity: O(1)
	* N as nodes
```
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
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as nodes
```
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode node = q.poll();
                res++;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                size--;
            }
        }
        return res;
    }
}
```