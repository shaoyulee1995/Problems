# Minimum Cost to Move Chips to The Same Position

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0,
            even = 0;
        for(int p: position){
            if(p%2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
```
