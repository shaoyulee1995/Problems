# Reformat The String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder(),
                      digits = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                digits.append(c);
            }else{
                letters.append(c);
            }
        }
        if(Math.abs(letters.length() - digits.length()) > 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean isDigit = (digits.length() >= letters.length());
        for(int i = 0, x = 0, y = 0; i < s.length(); i++, isDigit = !isDigit){
            sb.append(isDigit? digits.charAt(x++): letters.charAt(y++));
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String reformat(String s) {
        int charSize = 0,
            digitSize = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                digitSize++;
            }else{
                charSize++;
            }
        }
        if(Math.abs(charSize-digitSize) > 1){
            return "";
        }
        int x = (charSize > digitSize)? 0: 1,
            y = (x==0)? 1: 0;
        char[] res = s.toCharArray();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                res[x] = c;
                x += 2;
            }else{
                res[y] = c;
                y += 2;
            }
        }
        return new String(res);
    }
}
```
