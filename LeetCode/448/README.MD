# Find All Numbers Disappeared in an Array

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int v = Math.abs(nums[i])-1;
            nums[v] = -1*Math.abs(nums[v]);
        }
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}
```
