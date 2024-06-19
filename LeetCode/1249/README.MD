# Minimum Remove to Make Valid Parentheses

# String

- Time Complexity: O(S))
- Space Complexity: O(S)
  - S as length of s

```
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openP = 0,
            balance = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                balance++;
                openP++;
            }else if(c == ')'){
                if(balance==0){
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }

        StringBuilder result = new StringBuilder();
        int openToKeep = openP - balance;
        for(char c: sb.toString().toCharArray()){
            if(c == '('){
                openToKeep--;
                if(openToKeep < 0){
                    continue;
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
```
