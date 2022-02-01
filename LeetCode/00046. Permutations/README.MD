# Backtrack
* Time Complexity: O(N*N!)
* Space Complexity: O(N*N!)
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        permute(nums, visited);
        return list;
    }
    public void permute(int[] nums, boolean[] visited){
        if(path.size() == nums.length){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            permute(nums, visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
```