# BFS Set
* Time Complexity: O(V+E)
* Space Complexity: O(V+E)
	* V as vertices
	* E as edges
```
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges){
            int u = edge[0],
                v = edge[1];
            map.computeIfAbsent(u, x -> new ArrayList()).add(v);
            map.computeIfAbsent(v, x -> new ArrayList()).add(u);
        }
        HashSet<Integer> set = new HashSet();
        set.add(source);
        Queue<Integer> q = new LinkedList();
        q.offer(source);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                if(cur == destination){
                    return true;
                }
                for(int adj: map.get(cur)){
                    if(set.contains(adj)){
                        continue;
                    }
                    q.offer(adj);
                    set.add(adj);
                }
            }
        }
        return false;
    }
}
```
# BFS boolean
* Time Complexity: O(V+E)
* Space Complexity: O(V+E)
	* V as vertices
	* E as edges
```
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] edge: edges){
            int a = edge[0],
                b = edge[1];
            map.computeIfAbsent(a, val-> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, val-> new ArrayList<Integer>()).add(a);
        }
        boolean[] seen = new boolean[n];
        Queue<Integer> q = new LinkedList();
        q.offer(source);
        seen[source] = true;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == destination){
                return true;
            }
            for(int adj: map.get(p)){
                if(!seen[adj]){
                    q.offer(adj);
                    seen[adj] = true;
                }
            }
        }
        return false;
    }
}
```