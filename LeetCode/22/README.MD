# Generate Parentheses

- Time Complexity: O($\frac{4<sup>N</sup>}{\sqrt{N}}$)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, n);
        return res;
    }
    public void dfs(StringBuilder sb, int openCount, int closeCount){
        if(openCount == 0 && closeCount == 0){
            res.add(sb.toString());
            return;
        }
        if(openCount > closeCount){
            return;
        }
        if(openCount > 0){
            sb.append("(");
            dfs(sb, openCount-1, closeCount);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closeCount > 0){
            sb.append(")");
            dfs(sb, openCount, closeCount-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
```
