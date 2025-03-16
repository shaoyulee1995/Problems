# Alternating Group I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of colors

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        for(int i = 0; i < colors.length; i++){
            int cur = colors[i],
                prevIndex = (i-1+colors.length)%colors.length,
                nextIndex = (i+1+colors.length)%colors.length,
                prev = colors[prevIndex],
                next = colors[nextIndex];
            if(cur != prev && cur != next){
                res++;
            }
        }
        return res;
    }
}
```