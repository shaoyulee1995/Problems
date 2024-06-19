# Longest Happy String

# Recursion

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as a + b + c

```
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }
    public String generate(int a, int b, int c, String aa, String bb, String cc){
        if(a < b){
            return generate(b, a, c, bb, aa, cc);
        }
        if(b < c){
            return generate(a, c, b, aa, cc, bb);
        }
        if(b == 0){
            return aa.repeat(Math.min(2, a));
        }
        int useA = Math.min(2, a),
            useB = a - useA >= b? 1: 0;
        return aa.repeat(useA) + bb.repeat(useB) +
                generate(a - useA, b - useB, c, aa, bb, cc);
    }
}
```
