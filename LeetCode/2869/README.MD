# Minimum Number of Operations to Make Arrays Similar

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int minOperations(List<Integer> nums, int k) {
      HashSet<Integer> set = new HashSet();
      int res = 0;
      for(int i = nums.size()-1; i >= 0; i--){
        res++;
        if(nums.get(i) <= k){
          set.add(nums.get(i));
        }
        if(set.size() == k){
          break;
        }
      }
      return res;
    }
}
```