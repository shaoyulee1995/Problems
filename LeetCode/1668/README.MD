# Maximum Repeating Substring

- Time Complexity: O(NW)
- Space Complexity: O(S)
  - N as length of sequence
  - W as length of word

```
class Solution {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb)){
            res++;
            sb.append(word);
        }
        return res;
    }
}
```
