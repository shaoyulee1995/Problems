# Create Target Array in the Given Order

# Counting Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
```
