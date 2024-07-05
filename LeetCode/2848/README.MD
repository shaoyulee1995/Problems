# Points That Intersect With Cars

- Time Complexity: O(ND)
- Space Complexity: O(ND)
  - N as length of nums
    - D as range between each distance

```
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> set = new HashSet();
        for(List<Integer> num: nums){
            for(int i = num.get(0); i <= num.get(1); i++){
                set.add(i);
            }
        }
        return set.size();
    }
}
```
