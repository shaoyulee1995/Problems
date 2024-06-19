# Replace All Digits with Characters

# Sorting

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i+=2){
            char c = s.charAt(i);
            sb.append(c);
            if(i+1 == s.length()){
                break;
            }
            int digit = s.charAt(i+1)-'0';
            char inserted = (char)(c+digit);
            sb.append(inserted);
        }
        return sb.toString();
    }
}
```
