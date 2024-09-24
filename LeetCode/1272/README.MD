# Remove Interval

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of intervals

```java
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new ArrayList();
        for(int[] interval: intervals){
            if(interval[1] < toBeRemoved[0] || interval[0] > toBeRemoved[1]){
                list.add(Arrays.asList(interval[0], interval[1]));
            }else{
                if(interval[0] < toBeRemoved[0]){
                    list.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if(interval[1] > toBeRemoved[1]){
                    list.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }
        return list;
    }
}
```
