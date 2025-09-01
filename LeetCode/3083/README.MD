# Existence of a Substring in a String and Its Reverse

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public boolean isSubstringPresent(String s) {
        HashSet<String> set = new HashSet();
        for(int i = 1; i < s.length(); i++){
            set.add("" + s.charAt(i) + s.charAt(i-1));
        }
        String reverse = new StringBuilder(s).reverse().toString();
        for(int i = 1; i < reverse.length(); i++){
            if(set.contains("" + reverse.charAt(i) + reverse.charAt(i-1))){
                return true;
            }
        }
        return false;
    }
}
```