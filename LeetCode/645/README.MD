# Set Mismatch

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length+1];
        for(int num: nums){
            cnt[num]++;
        }
        int a = 0, b = 0;
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == 2){
                a = i;
            }else if(cnt[i] == 0){
                b = i;
            }
        }
        return new int[]{a,b};
    }
}
```
