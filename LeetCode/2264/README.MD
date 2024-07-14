# Largest 3-Same-Digit Number in String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of num

```java
class Solution {
    public String largestGoodInteger(String num) {
        Character c = null;
        for(int i = 1; i + 1 < num.length(); i++){
            char c1 = num.charAt(i-1),
                 c2 = num.charAt(i),
                 c3 = num.charAt(i+1);
            if(c1 == c2 && c2 == c3){
                if(c == null || c2 > c){
                    c = c2;
                }
            }
        }
        if(c == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            sb.append(c);
        }
        return sb.toString();
    }
}
```
