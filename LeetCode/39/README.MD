# Combination Sum
# Backtrack
* Time Complexity: O(S)
* Space Complexity: O(T)
	* S as the possible sum length
	* T as target
```
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList();
        path = new LinkedList();
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int idx){
        if(target == 0){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            if(target-nums[i] < 0){
                break;
            }
            path.add(nums[i]);
            dfs(nums, target-nums[i], i);
            path.removeLast();
        }
    }
}

```