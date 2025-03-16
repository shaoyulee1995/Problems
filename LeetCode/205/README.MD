# Isomorphic Strings

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Integer[] patternS = new Integer[256],
                  patternT = new Integer[256];
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i),
                 b = t.charAt(i);
            if(patternS[a] == null){
                patternS[a] = i;
            }
            if(patternT[b] == null){
                patternT[b] = i;
            }
            if(patternS[a] != patternT[b]){
                return false;
            }
        }
        return true;
    }
}
```
