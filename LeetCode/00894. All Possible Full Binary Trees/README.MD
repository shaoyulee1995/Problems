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
        List<TreeNode> res = new ArrayList();
        if(n%2 == 0){
            return res;
        }
        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }
        for(int l = 1; l <= n-1; l+=2){
            int r = n-1-l;
            List<TreeNode> leftTree = allPossibleFBT(l),
                           rightTree = allPossibleFBT(r);
            for(TreeNode left: leftTree){
                for(TreeNode right: rightTree){
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
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