# Check If String Is a Prefix of Array

- Time Complexity: O(WS)
- Space Complexity: O(W)
  - W as length of words
    - S as length of s

```
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            sb.append(word);
            if(sb.toString().equals(s)){
                return true;
            }
            if(sb.toString().indexOf(word) == -1){
                return false;
            }
        }
        return false;
    }
}
```
