# Number of Provinces

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of isConnected

```
class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int res = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] isConnected, int index){
        visited[index] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(isConnected[index][i] == 1 && !visited[i]){
                dfs(isConnected, i);
            }
        }
    }
}
```
