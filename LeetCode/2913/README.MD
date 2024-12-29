# Subarrays Distinct Elements Sum of Squares I

- Time Complexity: O(N^2)
- Space Complexity: O(N)
  - N as the size of nums

```java
class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        for(int i = 0; i < nums.size(); i++){
            HashSet<Integer> set = new HashSet();
            for(int j = i; j < nums.size(); j++){
                set.add(nums.get(j));
                res += Math.pow(set.size(), 2);
            }
        }
        return res;
    }
}
```