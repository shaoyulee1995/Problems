# Remove Palindromic Subsequences

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
          return 0;
        }
        if(isPalindrome(s)){
          return 1;
        }
        return 2;
    }

    public boolean isPalindrome(String s){
      int i = 0,
          j = s.length()-1;
      while(i < j){
        if(s.charAt(i++) != s.charAt(j--)){
          return false;
        }
      }
      return true;
    }
}
```
