# Palindrome Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of x

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x >= Integer.MAX_VALUE){
            return false;
        }
        int original = x,
            reverse = 0;
        while(x != 0){
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == original;
    }
}
```
