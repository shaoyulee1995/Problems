# Backtrack
* Time Complexity: O()
* Space Complexity: O(N)
	* N as n
```
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