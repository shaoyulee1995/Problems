# Arithmetic Subarrays

- Time Complexity: O(LClog(C))
- Space Complexity: O(L(R-L))
  - R as right index
  - L as left index
  - C as length of copy

```java
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList();
        for(int i = 0; i < l.length; i++){
            res.add(checkArithmeticSubarrays(nums, l[i], r[i]));
        }
        return res;
    }
    public boolean checkArithmeticSubarrays(int[] nums, int l, int r) {
        int[] copy = Arrays.copyOfRange(nums, l, r+1);
        if(copy.length < 2){
            return false;
        }
        Arrays.sort(copy);
        int diff = copy[1] - copy[0];
        for(int i = 1; i < copy.length; i++){
            if(diff != copy[i] - copy[i-1]){
                return false;
            }
        }
        return true;
    }
}
```
