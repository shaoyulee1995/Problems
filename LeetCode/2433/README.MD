# Find The Original Array of Prefix Xor

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of pref

```java
class Solution {
    public int[] findArray(int[] pref) {
        for(int i = pref.length-1; i >= 1; i--){
            pref[i] = pref[i-1] ^ pref[i];
        }
        return pref;
    }
}
```
