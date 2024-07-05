# Maximum Population Year

- Time Complexity: O(L)
- Space Complexity: O(1)
  - L as L of logs

```
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[2051];
        int res = 0;
        for(int[] log: logs){
            years[log[0]]++;
            years[log[1]]--;
        }
        for(int i = 1950; i <= 2050; i++){
            years[i] += years[i-1];
            res = years[i] > years[res]? i: res;
        }
        return res;
    }
}
```
