# Find Center of Star Graph

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int findCenter(int[][] edges) {
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])?
                edges[0][0]:edges[0][1];
    }
}
```

- Time Complexity: O(E)
- Space Complexity: O(E)
  - E as length of edges

```java
class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int[] edge: edges){
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) == edges.length){
                return key;
            }
        }
        return 0;
    }
}
```
