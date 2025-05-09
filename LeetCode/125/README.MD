# Valid Palindrome

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0,
            j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j){
            char a = s.charAt(i),
                 b = s.charAt(j);
            while(i < j && !isValid(a)){
                a = s.charAt(++i);
            }
            while(i < j && !isValid(b)){
                b = s.charAt(--j);
            }
            if(a != b){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    private boolean isValid(char w){
        return w <= 'z' && w >= 'a' ||
               w <= 'Z' && w >= 'A' ||
               w <= '9' && w >= '0';
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s
  
```java
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0,
            j = s.length()-1;
        while(i < j){
            while(i < j && !isValidCharacter(s.charAt(i))){
                i++;
            }
            while(i < j && !isValidCharacter(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isValidCharacter(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
```