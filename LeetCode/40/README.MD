# Combination Sum II

- Time Complexity: O(2<sup>N</sup>)
- Space Complexity: O(N)
  - N as length of candidates

```java
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        combinationSum2(nums, target, 0, visited);
        return list;
    }
    public void combinationSum2(int[] nums, int target, int index, boolean[] visited){
        if(target == 0){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            if(i > index && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(target - nums[i] < 0){
                break;
            }
            visited[i] = true;
            target -= nums[i];
            path.add(nums[i]);
            combinationSum2(nums, target, i+1, visited);
            target += nums[i];
            visited[i] = false;
            path.removeLast();
        }
    }
}
```
