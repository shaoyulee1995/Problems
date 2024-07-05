# Maximum Length of Pair Chain

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of pairs

```
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 0,
            prevEnd = Integer.MIN_VALUE;
        for(int[] pair: pairs){
            if(pair[0] > prevEnd){
                res++;
                prevEnd = pair[1];
            }
        }
        return res;
    }
}
```
