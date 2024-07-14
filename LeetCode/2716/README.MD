# Minimize String Length

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int minimizedStringLength(String s) {
      return (int) s.chars().distinct().count();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int minimizedStringLength(String s) {
      int[] cnt = new int[26];
      int res = 0;
      for(char c: s.toCharArray()){
        if(cnt[c-'a']++ == 0){
          res++;
        }
      }
      return res;
    }
}
```
