# Snake in Matrix

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of commands

```java
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = 0;
        for(String command: commands){
            switch(command){
                case "UP" -> res -= n;
                case "DOWN" -> res += n;
                case "RIGHT" -> res += 1;
                case "LEFT" -> res -= 1;
            }
        }
        return res;
    }
}
```
