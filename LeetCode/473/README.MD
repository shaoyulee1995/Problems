# Matchsticks to Square

- Time Complexity: O(N\*2<sup>N</sup>)
- Space Complexity: O(N)
  - N as length of matchsticks

```java
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4 != 0){
            return false;
        }
        Arrays.sort(matchsticks);
        boolean[] visited = new boolean[matchsticks.length];
        return dfs(matchsticks, 0, 0, 4, sum/4, visited);
    }

    public boolean dfs(int[] nums, int idx, int sum, int k, int target, boolean[] visited){
        if(k == 1){
            return true;
        }
        if(sum == target){
            return dfs(nums, 0, 0, k-1, target, visited);
        }
        for(int i = idx; i < nums.length; i++){
            if(visited[i] || i > idx && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(nums[i] + sum > target){
                break;
            }
            visited[i] = true;
            if(dfs(nums, i+1, sum+nums[i], k, target, visited)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
```
