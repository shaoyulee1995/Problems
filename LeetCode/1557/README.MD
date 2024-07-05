# Minimum Number of Vertices to Reach All Nodes

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of edge

```
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList();
        int[] cnt = new int[n];
        for(List<Integer> edge: edges){
            cnt[edge.get(1)] = 1;
        }
        for(int i = 0; i < n; i++){
            if(cnt[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
}
```
