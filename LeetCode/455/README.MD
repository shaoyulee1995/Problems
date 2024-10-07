# Assign Cookies

- Time Complexity: O(Max(NlogN, MlogM))
- Space Complexity: O(1)
  - N as length of g
  - M as length of s

```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,
            j = 0,
            res = 0;
        while(i < g.length && j < s.length){
           if(g[i] > s[j]){
               j++;
           }else{
               i++;
               j++;
               res++;
           }
        }
        return res;
    }
}
```
