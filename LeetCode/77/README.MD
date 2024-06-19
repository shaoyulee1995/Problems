# Combinations

# Backtrack

- Time Complexity: O(c(n, k)\*k)
- Space Complexity: O(k)

```
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList();
        path = new LinkedList();
        dfs(n, k, 1);
        return res;
    }
    public void dfs(int n, int k, int num){
        if(path.size() == k){
            res.add(new ArrayList(path));
        }else{
            for(int val = num; val <= n - (k - path.size())+1; val++){
                path.add(val);
                dfs(n, k, val+1);
                path.removeLast();
            }
        }
    }
}
```
