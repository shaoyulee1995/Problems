# Minimum Changes To Make Alternating Binary String

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int minOperations(String s) {
        int c1 = 0,
            c2 = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i%2 != c-'0'){
                c1++;
            }
        }
        return Math.min(c1, s.length() - c1);
    }
}
```
