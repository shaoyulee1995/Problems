# Two Sum

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap();
    for(int i = 0; i < nums.length; i++){
        int complement = target - nums[i];
        if(map.containsKey(complement)){
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return null;
  }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```python
class Solution(object):
  def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    d = {}
    for i, n in enumerate(nums):
        remaining = target - n
        if remaining in d:
            return [d[remaining], i]
        d[n] = i
```
