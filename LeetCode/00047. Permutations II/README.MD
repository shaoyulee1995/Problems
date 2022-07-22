# Backtrack
* Time Complexity: O(N*N!)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
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