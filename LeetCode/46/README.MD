# Permutations
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
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
```