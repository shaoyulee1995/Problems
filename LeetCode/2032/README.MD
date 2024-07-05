# Two Out of Three

- Time Complexity: O(Max(N1,N2,N3))
- Space Complexity: O(101)
  - N1 as length of nums1
  - N2 as length of nums2
  - N3 as length of nums3

```
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList();
        int[][] cnt = new int[3][101];
        for(int num: nums1){
          cnt[0][num] = 1;
        }
        for(int num: nums2){
          cnt[1][num] = 1;
        }
        for(int num: nums3){
          cnt[2][num] = 1;
        }
        for(int i = 1; i <= 100; i++){
          if(cnt[0][i] + cnt[1][i] + cnt[2][i] > 1){
            res.add(i);
          }
        }
        return res;
    }
}
```
