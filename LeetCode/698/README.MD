# Partition to K Equal Sum Subsets

- Time Complexity: O(N\*2<sup>N</sup>)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        boolean[] visited = new boolean[nums.length];
        if(sum%k != 0){
            return false;
        }
        Arrays.sort(nums);
        return dfs(nums, k, 0, 0, visited, sum/k);
    }

    public boolean dfs(int[] nums, int k, int idx, int curSum, boolean[] visited, int target){
        if(k == 1){
            return true;
        }
        if(curSum == target){
            return dfs(nums, k-1, 0, 0, visited, target);
        }
        for(int i = idx; i < nums.length; i++){
            if(visited[i] || i > idx && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(nums[i] + curSum > target){
                break;
            }
            visited[i] = true;
            if(dfs(nums, k, i+1, curSum + nums[i], visited, target)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
```
