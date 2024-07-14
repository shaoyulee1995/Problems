# Find the Difference of Two Arrays

# Bits

- Time Complexity: O(max(N, M))
- Space Complexity: O(max(N, M))
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet(),
                         set2 = new HashSet();
        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        res.add(new ArrayList());
        for(int num: set1){
            if(!set2.contains(num)){
                res.get(0).add(num);
            }
        }
        for(int num: set2){
            if(!set1.contains(num)){
                res.get(1).add(num);
            }
        }
        return res;
    }
}
```
