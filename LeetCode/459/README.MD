# Repeated Substring Pattern

- Time Complexity: O(N^2)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = n/2; i > 0; i--){
            if(n%i == 0){
                int left = 0,
                    right = i;
                while(right < n && s.charAt(left) == s.charAt(right)){
                    right++;
                    left++;
                }
                if(right == n){
                    return true;
                }
            }
        }
        return false;
    }
}
```
