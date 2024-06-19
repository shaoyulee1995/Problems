# Increasing Subsequences

# Backtrack

- Time Complexity: O(2<sup>N</sup>N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    Set<List<Integer>> list = new HashSet();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequences(nums, 0);
        return new ArrayList(list);
    }
    public void findSubsequences(int[] nums, int index){
        if(path.size() > 1){
            list.add(new ArrayList(path));
        }
        for(int i = index; i < nums.length; i++){
            if(path.isEmpty() || path.get(path.size() - 1) <= nums[i]){
                path.add(nums[i]);
                findSubsequences(nums, i+1);
                path.removeLast();
            }
        }
    }
}

```
