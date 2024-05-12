# Reorder Routes to Make All Paths Lead to the City Zero
# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of connections
```
class Solution {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, ArrayList<dest>> map = new HashMap();
        for(int i = 0; i < n; i++){ 
            map.put(i, new ArrayList());
        }
        for(int[] c: connections){
            int u = c[0],
                v = c[1];
            map.get(u).add(new dest(v, true));
            map.get(v).add(new dest(u, false));
        }
        Queue<Integer> q = new LinkedList();
        q.offer(0);
        int res = 0;
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;
            for(dest d: map.get(node)){
                if(visited[d.to]){
                    continue;
                }
                if(d.path){
                    res++;
                }
                q.offer(d.to);
                visited[d.to] = true;
            }
        }
        return res;
    }
}
```
```
class dest{
    int to;
    boolean path;
    public dest(int to, boolean path){
        this.path = path;
        this.to = to;
    }
}
```