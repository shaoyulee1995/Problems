# Determine Color of a Chessboard Square

- Time Complexity: O(1)
- Space Complexity: O(1)

```
class Solution {
    public boolean squareIsWhite(String coordinates) {
        return coordinates.charAt(0)%2 != coordinates.charAt(1)%2;
    }
}
```
