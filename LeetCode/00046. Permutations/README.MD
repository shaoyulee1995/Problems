# Backtrack
* Time Complexity: O(N*N!)
* Space Complexity: O(N!)
```
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList();
        path = new LinkedList();
        HashSet<Integer> set = new HashSet();
        dfs(nums, set);
        return res;
    }
    public void dfs(int[] nums, HashSet<Integer> set){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, set);
            path.removeLast();
            set.remove(nums[i]);
        }
    }    
}
```