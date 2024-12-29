# Sum of Values at Indices With K Set Bits

- Time Complexity: O(NB)
- Space Complexity: O(1)
  - N as length of nums
  - B as length of nums[i]

```java
class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.size(); i++){
            if(isBitsK(i, k)){
                res += nums.get(i);
            }
        }
        return res;
    }

    boolean isBitsK(int num, int k){
        int res = 0;
        while(num != 0){
            res += (num&1);
            if(res > k){
                return false;
            }
            num >>= 1;
        }
        return res == k;
    }
}
```