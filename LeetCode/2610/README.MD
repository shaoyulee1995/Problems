# Convert an Array Into a 2D Array With Conditions

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int[] cnt = new int[nums.length + 1];
        for(int num: nums){
            if(res.size() <= cnt[num]){
                res.add(new ArrayList());
            }
            res.get(cnt[num]).add(num);
            cnt[num]++;
        }
        return res;
    }
}
```
