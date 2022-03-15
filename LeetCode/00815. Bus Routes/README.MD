# BFS
* Time Complexity: O(NS)
* Space Complexity: O(NS)
	* N as length of routes
	* S as number of stop in route[i]
```
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        int n = routes.length;
        for(int i = 0; i < n; i++){
            for(int stopSign: routes[i]){
                if(!map.containsKey(stopSign)){
                    map.put(stopSign, new HashSet());
                }
                map.get(stopSign).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{source, 0});//stop, busCount
        HashSet<Integer> seen = new HashSet();
        seen.add(source);
        while(!q.isEmpty()){
            int stop = q.peek()[0],
                bus = q.peek()[1];
            q.poll();
            if(stop == target){
                return bus;
            }
            for(int busCount: map.get(stop)){
                if(visited[busCount]){
                    continue;
                }
                for(int route: routes[busCount]){
                    if(!seen.contains(route)){
                        seen.add(route);
                        q.offer(new int[]{route, bus+1});
                    }
                }
                visited[busCount] = true;
            }
        }
        return -1;
    }
}
```