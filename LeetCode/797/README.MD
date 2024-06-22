# All Paths From Source to Target

- Time Complexity: O((2^N)\*(N^2))
- Space Complexity: O((2^N)\*N)

```java
class Solution {
    List<List<Integer>> res = new LinkedList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList();
        traverse(path, 0, graph);
        return res;
    }
    public void traverse(LinkedList<Integer> path, int s, int[][] graph){
        path.addLast(s);
        if(s == graph.length - 1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for(int v: graph[s]){
            traverse(path, v, graph);
        }
        path.removeLast();
    }
}
```

```java
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        LinkedList<Integer> path = new LinkedList();
        path.add(0);
        traverse(graph, 0, ans, path);
        return ans;
    }
    public void traverse(int[][] graph, int s, List<List<Integer>> ans, LinkedList<Integer> path){
        if(s == graph.length - 1){
            ans.add(new ArrayList(path));
            return;
        }
        for(int v: graph[s]){
            path.add(v);
            traverse(graph, v, ans, path);
            path.removeLast();
        }
    }
}
```
