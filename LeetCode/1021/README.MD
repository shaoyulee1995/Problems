# Remove Outermost Parentheses

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public String removeOuterParentheses(String S) {
        int opened = 0;
        StringBuilder sb = new StringBuilder();

        for(char c: S.toCharArray()){
            if(c =='(' && opened++ > 0){
                sb.append(c);
            }
            if(c ==')' && opened-- > 1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public String removeOuterParentheses(String s) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        boolean add = false;
        for(char c: s.toCharArray()){
            if(c == '('){
                res++;
            }else if(c == ')'){
                res--;
            }
            if(c == '(' && res == 2){
                add = true;
            }else if(c == ')' && res == 0){
                add = false;
            }
            if(add){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
