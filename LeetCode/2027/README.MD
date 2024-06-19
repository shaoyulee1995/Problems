# Minimum Moves to Convert String

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public int minimumMoves(String s) {
        int res = 0,
            i = 0;
        while(i < s.length()){
          if(s.charAt(i) == 'X'){
            res++;
            i+=3;
          }else{
            i++;
          }
        }
        return res;
    }
}
```
