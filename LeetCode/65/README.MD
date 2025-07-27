# Valid Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        boolean dotSeen = false,
                eSeen = false,
                numberBeforeE = false,
                numberAfterE = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if('0' <= c && c <= '9'){
                if(!eSeen) {
                    numberBeforeE = true;
                }
                if(eSeen) {
                    numberAfterE = true;
                }
            }else if(c == '.'){
                if(dotSeen || eSeen){ 
                    return false;
                }
                dotSeen = true;
            }else if(c == '+' || c == '-'){
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            }else if(c == 'e'){
                if(eSeen){
                    return false;
                }
                eSeen = true;
            }else{
                return false;
            }
        }
        return eSeen? (numberBeforeE && numberAfterE): numberBeforeE;
    }
}
```