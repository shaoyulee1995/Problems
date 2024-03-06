# BFS
* Time Complexity: O(NS)
* Space Complexity: O(NS)
	* N as length of routes
	* S as number of stop in route[0]
```
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < routes.length; i++){
            for(int bus: routes[i]){
                map.computeIfAbsent(bus, x -> new ArrayList()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visitedPath = new HashSet(),
                         visitedStop = new HashSet();
        int res = 0;
        q.offer(source);
        visitedStop.add(source);
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i < size; i++){
                int curStop = q.poll();
                for(int path: map.getOrDefault(curStop, new ArrayList<>())){
                    if(visitedPath.contains(path)){
                        continue;
                    }
                    visitedPath.add(path);
                    for(int nextStop: routes[path]){
                        if(visitedStop.contains(nextStop)){
                            continue;
                        }
                        visitedStop.add(nextStop);
                        if(nextStop == target){
                            return res;
                        }
                        q.offer(nextStop);
                    }
                }    
            }
        }
        return -1;
    }
}
```