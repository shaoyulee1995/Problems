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
# String
* Time Complexity: O(CN)
* Space Complexity: O(N)
	* C as vertical column in tree
	* N as number of nodes in tree
```
class Solution {
    TreeMap<Integer, List<int[]>> map;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new TreeMap();
        dfs(root, 0, 0);
        List<List<Integer>> list = new ArrayList();
        for(Integer key: map.keySet()){
            List<int[]> arr = map.get(key);
            Collections.sort(arr, (a, b)->a[0] - b[0]);
            List<Integer> nums = new ArrayList();
            for(int i = 0; i < arr.size(); i++){
                nums.add(arr.get(i)[1]);
            }
            list.add(nums);
        }
        return list;
    }
    public void dfs(TreeNode root, int depth, int offset){
        if(root == null){
            return;
        }
        if(!map.containsKey(offset)){
            map.put(offset, new LinkedList());
        }
        map.get(offset).add(new int[]{depth, root.val});
        dfs(root.left,  depth+1, offset-1);
        dfs(root.right, depth+1, offset+1);
    }
}
```