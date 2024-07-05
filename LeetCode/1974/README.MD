# Minimum Time to Type Word Using Special Typewriter

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```
class Solution {
    public int minTimeToType(String word) {
        int res = word.length();
        char prev = 'a';
        for(char c: word.toCharArray()){
            int diff = Math.abs(c-prev);
            res += Math.min(diff, 26-diff);
            prev = c;
        }
        return res;
    }
}
```
