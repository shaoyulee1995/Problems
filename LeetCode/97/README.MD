# Interleaving String

# DFS

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of s1
  - M as length of s2

```
class Solution {
    boolean[][] invalid;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        invalid = new boolean[s1.length()+1][s2.length()+1];
        return dfs(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    public boolean dfs(char[] s1, int i, char[] s2, int j, char[] s3, int k){
        if(invalid[i][j]){
            return false;
        }
        if(k == s3.length){
            return true;
        }
        boolean valid = (i < s1.length && s1[i] == s3[k] && dfs(s1, i+1, s2, j, s3, k+1) ||
                         j < s2.length && s2[j] == s3[k] && dfs(s1, i, s2, j+1, s3, k+1));
        if(!valid){
            invalid[i][j] = true;
        }
        return valid;
    }
}
```
