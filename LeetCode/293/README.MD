# Flip Game

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
    List<String> res = new ArrayList();
    for(int i = 1; i < s.length(); i++){
      if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, '-');
        sb.setCharAt(i-1, '-');
        res.add(sb.toString());
      }
    }
    return res;
    }
}
```
