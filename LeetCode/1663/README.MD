# Smallest String With A Given Numeric Value

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for(int i = n-1; i >= 0; i--){
            int pos = Math.min(26, k-i);
            res[i] = (char)(pos + 'a' - 1);
            k -= pos;
        }
        return new String(res);
    }
}
```
