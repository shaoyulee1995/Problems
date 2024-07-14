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
        Integer[] cntS = new Integer[256],
                  cntT = new Integer[256];
        int n = s.length();
        for(int i = 0; i < n; i++){
            char sChar = s.charAt(i),
                 tChar = t.charAt(i);
            if(cntT[tChar] == null){
                cntT[tChar] = i;
            }
            if(cntS[sChar] == null){
                cntS[sChar] = i;
            }
            if(cntS[sChar] != cntT[tChar]){
                return false;
            }
        }
        return true;
    }
}
```
