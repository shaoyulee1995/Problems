# Minimum Absolute Difference

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of arr

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
          int curDiff = arr[i] - arr[i-1];
          if(curDiff < minDiff){
            minDiff = curDiff;
            res.clear();
            res.add(Arrays.asList(arr[i-1], arr[i]));
          }else if(curDiff == minDiff){
            res.add(Arrays.asList(arr[i-1], arr[i]));
          }
        }
        return res;
    }
}
```
