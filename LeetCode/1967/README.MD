# Number of Strings That Appear as Substrings in Word

# String

- Time Complexity: O(PW)
- Space Complexity: O(1)
  - N as length of patterns
    - W as length of word

```
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String pattern: patterns){
            if(word.indexOf(pattern) != -1){
                res++;
            }
        }
        return res;
    }
}
```
