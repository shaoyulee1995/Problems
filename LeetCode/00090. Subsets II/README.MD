# Backtrack
* Time Complexity: O(N*2^N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        subsetsWithDup(nums, 0, visited);
        return list;
    }
    public void subsetsWithDup(int[] nums, int index, boolean[] visited){
        list.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            subsetsWithDup(nums, i + 1, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
```