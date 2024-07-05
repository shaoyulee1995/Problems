# Maximum Number of Coins You Can Get

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0,
            j = piles.length - 2,
            sum = 0;
        while(i < j){
            sum += piles[j];
            j-=2;
            i++;
        }
        return sum;
    }
}
```
