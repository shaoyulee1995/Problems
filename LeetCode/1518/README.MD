# Water Bottles

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as numBottles

```
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles >= numExchange){
            int remainder = numBottles % numExchange;
            numBottles /= numExchange;
            res += numBottles;
            numBottles += remainder;
        }
        return res;
    }
}
```
