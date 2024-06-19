# To Lower Case

# Array

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
```
