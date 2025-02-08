# Arithmetic Slices II - Subsequence

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as the length of nums

```java

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        HashMap<Long, Integer>[] map = new HashMap[nums.length];
        Arrays.setAll(map, x -> new HashMap());
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                long diff = 1L * nums[i] - nums[j];
                int pairs = map[j].getOrDefault(diff, 0);
                map[i].put(diff, 1 + map[i].getOrDefault(diff, 0) + pairs);
                res += pairs;
            }
        }
        return res;
    }
}
```