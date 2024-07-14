# Furthest Point From Origin

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of moves

```java
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int dash = 0,
            bal = 0;
        for(char c: moves.toCharArray()){
            if(c == 'L'){
                bal--;
            }else if(c == 'R'){
                bal++;
            }else if(c == '_'){
                dash++;
            }
        }
        return Math.abs(bal) + dash;
    }
}
```
