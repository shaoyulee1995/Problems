# Minimum Suffix Flips

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of target

```
class Solution {
    public int minFlips(String target) {
        int state = 0,
            res = 0;
        for(char c: target.toCharArray()){
            if(c - '0' != state){
                state = c - '0';
                res++;
            }
        }
        return res;
    }
}
```
