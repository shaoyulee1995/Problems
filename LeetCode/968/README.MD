# Binary Tree Cameras

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
  - N as nodes in tree

```java
class Solution{
    int res;
    public enum Camera {HAS_CAMERA, COVERED, PLEASE_COVER};
    public int minCameraCover(TreeNode root) {
        res = 0;
        return cover(root) == Camera.PLEASE_COVER? ++res: res;
    }

    public Camera cover(TreeNode node){
        if(node == null){
            return Camera.COVERED;
        }
        Camera left = cover(node.left),
                right = cover(node.right);
        if(left == Camera.PLEASE_COVER || right == Camera.PLEASE_COVER){
            res++;
            return Camera.HAS_CAMERA;
        }
        if(left == Camera.HAS_CAMERA || right == Camera.HAS_CAMERA){
            return Camera.COVERED;
        }
        return Camera.PLEASE_COVER;
    }
}
```
