# Maximum Manhattan Distance After K Changes

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int maxDistance(String s, int k) {
        int res = 0,
            N = 0,
            W = 0,
            S = 0,
            E = 0;
        for(char c: s.toCharArray()){
            switch(c){
                case 'N': N++; break;
                case 'W': W++; break;
                case 'E': E++; break;
                case 'S': S++; break;
                default: break;
            }
            int dist = Math.abs(S-N) + Math.abs(W-E),
                min1 = Math.min(S, N),
                min2 = Math.min(W, E);
            res = Math.max(res, dist + Math.min(min1+min2, k) * 2);
        }
        return res;
    }
}
```