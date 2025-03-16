# Valid Palindrome II

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the string

```java
class Solution {
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                boolean deleteLeftPosition = isPalindrome(s, i+1, j),
                        deleteRightPosition = isPalindrome(s, i, j-1);
                return deleteLeftPosition || deleteRightPosition;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```
