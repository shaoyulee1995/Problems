# Advantage Shuffle

# TreeMap

- Time Complexity: O(Nlog(N))
- Space Complexity: O(N)

```
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            Integer val = map.higherKey(nums2[i]);
            if(val == null){
                val = map.firstKey();
            }
            res[i] = val;
            map.put(val, map.get(val) - 1);
            if(map.get(val) == 0){
                map.remove(val);
            }
        }

        return res;
    }
}
```
