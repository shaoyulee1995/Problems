# Find the K-or of an Array

- Time Complexity: O(NlogM)
- Space Complexity: O(N)
  - N as length of nums
  - M as max value in nums

```java
class Solution {
    public int findKOr(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            while(nums[i] != 0){
                map.computeIfAbsent(j, x -> new ArrayList());
                if((nums[i]&1) == 1){
                    map.get(j).add(i);
                }
                nums[i] >>= 1;
                j++;
            }
        }
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() >= k){
                res += Math.pow(2, entry.getKey());
            }
        }
        return res;
    }
}
```
