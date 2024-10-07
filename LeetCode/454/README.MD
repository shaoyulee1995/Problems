# 4Sum II

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N<sup>2</sup>)
  - N as length of nums

```java
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int a: nums1){
            for(int b: nums2){
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for(int c: nums3){
            for(int d: nums4){
                int sum = c + d;
                if(map.containsKey(-sum)){
                    res += map.get(-sum);
                }
            }
        }
        return res;
    }
}
```
