# Number of Equivalent Domino Pairs

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of dominoes

```
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int[] d: dominoes){
            int k = Math.min(d[0], d[1])*10 + Math.max(d[0], d[1]);
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        for(int v: map.values()){
            res += v*(v-1)/2;
        }
        return res;
    }
}
```
