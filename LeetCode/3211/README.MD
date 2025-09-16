# Generate Binary Strings Without Adjacent Zeros

- Time Complexity: O(2<sup>N</sup>)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    List<String> res;
    public List<String> validStrings(int n) {
        res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(sb, n);
        return res;
    }

    private void dfs(StringBuilder sb, int n){
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }
        sb.append("1");
        dfs(sb, n);
        sb.setLength(sb.length()-1);
        if(sb.length() == 0 || sb.charAt(sb.length()-1) == '1'){
            sb.append("0");
            dfs(sb, n);
            sb.setLength(sb.length()-1);
        }
    }
}
```