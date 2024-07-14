# Path Crossing

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of path

```java
class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0,
            y = 0;
        HashSet<String> visit = new HashSet();
        visit.add(0+","+0);
        for(char c: path.toCharArray()){
          if(c == 'N'){
            y++;
          }else if(c == 'S'){
            y--;
          }else if(c == 'E'){
            x++;
          }else if(c == 'W'){
            x--;
          }
          if(!visit.add(x+","+y)){
            return true;
          }
        }
        return false;
    }
}
```
