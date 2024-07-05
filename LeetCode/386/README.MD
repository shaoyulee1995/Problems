# Lexicographical Numbers My SubmissionsBack to Contest

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```
class Solution {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList();
        for(int i = 1; i < 10; i++){
            dfs(i, n);
        }
        return res;
    }
    public void dfs(int num, int n){
        if(num <= n){
            res.add(num);
            for(int i = 0; i < 10; i++){
                if(num*10+i > n){
                    return;
                }
                dfs(num*10+i, n);
            }
        }
    }
}
```
