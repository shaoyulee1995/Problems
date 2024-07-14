# Lexicographically Smallest Palindrome

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0, j = s.length()-1; i < s.length(); i++, j--){
            sb.append(Character.toString(Math.min(s.charAt(i), s.charAt(j))));
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] c = s.toCharArray();
        int i = 0,
            j = s.length() - 1;
        while(i < j){
            if(c[i] < c[j]){
                c[j--] = c[i++];
            }else{
                c[i++] = c[j--];
            }
        }
        return new String(c);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] c = s.toCharArray();
        for(int i = 0, j = s.length()-1; i <= s.length()/2; i++, j--){
            if(c[i] < c[j]){
                c[j] = c[i];
            }else{
                c[i] = c[j];
            }
        }
        return new String(c);
    }
}
```
