# Count Prefixes of a Given String

- Time Complexity: O(Ww)
- Space Complexity: O(1)
  - W as length of words
  - w as the maximum length word

```
class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(String word: words){
            if(s.indexOf(word) == 0){
                res++;
            }
        }
        return res;
    }
}
```
