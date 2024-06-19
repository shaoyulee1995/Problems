# 1-bit and 2-bit Characters

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        for(int i = bits.length -2; i >= 0 && bits[i] == 1; i--){
                ones++;
        }
        return ones%2 == 0;
    }
}
```
