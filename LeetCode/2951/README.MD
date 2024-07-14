# Find the Peaks

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of mountain

```java
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList();
        for(int i = 1; i+1 < mountain.length; i++){
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]){
                res.add(i);
            }
        }
        return res;
    }
}
```
