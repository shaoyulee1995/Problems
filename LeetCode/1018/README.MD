# Binary Prefix Divisible By 5

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int k = 0;
        List<Boolean> res = new ArrayList();
        for(int num: nums){
            k = (k<<1 | num)%5;
            res.add(k==0);
        }
        return res;
    }
}
```
