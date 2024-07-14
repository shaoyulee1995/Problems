# Special Array With X Elements Greater Than or Equal X

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int specialArray(int[] nums) {
        int[] cnt = new int[nums.length+1];
        for(int num: nums){
            if(num >= nums.length){
                cnt[nums.length]++;
            }else{
                cnt[num]++;
            }
        }
        for(int i = cnt.length-1, res = 0; i > 0; i--){
            res += cnt[i];
            if(res == i){
                return res;
            }
        }
        return -1;
    }
}
```
