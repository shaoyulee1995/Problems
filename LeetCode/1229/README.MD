# Meeting Scheduler

- Time Complexity: O(Max(NlogN, MlogM))
- Space Complexity: O(1)
  - N as length of slots1
  - M as length of slots2

```
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i = 0,
            j = 0,
            n = slots1.length,
            m = slots2.length,
            start = Integer.MIN_VALUE,
            end = Integer.MAX_VALUE;
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        while(i < n && j < m){
            start = Math.max(slots1[i][0], slots2[j][0]);
            end = Math.min(slots1[i][1], slots2[j][1]);
            if(end - start >= duration){
                return List.of(start, start + duration);
            }else if(slots1[i][1] < slots2[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return new ArrayList();
    }
}
```
