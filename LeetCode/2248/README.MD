# Intersection of Multiple Arrays

# Counting Array

- Time Complexity: O(Max(NM, 1001))
- Space Complexity: O(1001)
  - N as length of num
  - M as length of num[0]

```
class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList();
        int[] cnt = new int[1001];
        for(int[] num: nums){
            for(int n: num){
                cnt[n]++;
            }
        }
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == nums.length){
                res.add(i);
            }
        }
        return res;
    }
}
```
