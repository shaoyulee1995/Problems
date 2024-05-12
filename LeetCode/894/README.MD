# All Possible Full Binary Trees
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
# DFS
* Time Complexity: O(2<sup>N</sup>)
* Space Complexity: O(2<sup>N</sup>)
```
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0 || n <= 0){
            return new ArrayList();
        }
        List<TreeNode> res = new ArrayList();
        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }
        for(int i = 1; i < n; i+=2){
            List<TreeNode> left = allPossibleFBT(i),
                           right = allPossibleFBT(n-1-i);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode node = new TreeNode(0);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
```
# Memorization HashMap
* Time Complexity: O(2<sup>N</sup>)
* Space Complexity: O(2<sup>N</sup>)
```
class Solution {
    HashMap<Integer, List<TreeNode>> map = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!map.containsKey(n)){
            List<TreeNode> res = new ArrayList();
            if(n%2 == 0){
                return res;
            }
            if(n == 1){
                res.add(new TreeNode(0));
                return res;
            }
            for(int l = 1; l <= n-1; l++){
                int r = n-1-l;
                List<TreeNode> leftList = allPossibleFBT(l),
                               rightList = allPossibleFBT(r);
                for(TreeNode left: leftList){
                    for(TreeNode right: rightList){
                        TreeNode node = new TreeNode(0);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
            map.put(n, res);
        }
        return map.get(n);
    }
}
```