# Keep Multiplying Found Values by Two

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums){
            set.add(num);
        }
        while(set.contains(original)){
            original *= 2;
        }
        return original;
    }
}
```
