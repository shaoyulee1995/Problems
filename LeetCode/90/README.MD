# Subsets II

- Time Complexity: O(N\*2<sup>N</sup>)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList();
        path = new LinkedList();
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int index){
        res.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i+1);
            path.removeLast();
        }
    }
}
```
