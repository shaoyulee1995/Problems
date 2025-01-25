# Minimum Cost of Buying Candies With Discount

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of cost

```java
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0,
            j = cost.length-1;
        while(j >= 0){
            int x = (j >= 0)? cost[j]: 0,
                y = (j-1 >= 0)? cost[j-1]: 0;
            res += x + y;
            j -= 3;
        }
        return res;
    }
}
```
