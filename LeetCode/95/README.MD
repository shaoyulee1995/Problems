# Unique Binary Search Trees II

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

- Time Complexity: O((4<sup>n</sup>)/(n<sup>0.5</sup>))
- Space Complexity: O((4<sup>n</sup>)/(n<sup>0.5</sup>))

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList();
        }
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i-1),
                           right = generateTrees(i+1, end);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode node = new TreeNode(i, l, r);
                    list.add(node);
                }
            }
        }
        return list;
    }
}
```
