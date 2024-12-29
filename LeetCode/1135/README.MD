# Connecting Cities With Minimum Cost

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N is the number of cities

```java
class Solution {
    public int minimumCost(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        HashMap<Integer, List<int[]>> map = new HashMap();
        for(int[] connection: connections){
            int a = connection[0],
                b = connection[1],
                distanceCost = connection[2];
            map.computeIfAbsent(a, x -> new ArrayList<>()).add(new int[]{b, distanceCost});
            map.computeIfAbsent(b, x -> new ArrayList<>()).add(new int[]{a, distanceCost});
        }
        HashSet<Integer> visited = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{1, 1, 0}); //src, dest, cost
        int res = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int src = node[0],
                dest = node[1],
                cost = node[2];
            if(visited.contains(dest)){
                continue;
            }
            res += cost;
            visited.add(dest);
            for(int[] neighbor: map.get(dest)){
                int newDestination = neighbor[0],
                    newDestinationDistanceCost = neighbor[1];
                pq.offer(new int[]{dest, newDestination, newDestinationDistanceCost});
            }
        }

        return visited.size() == n? res: -1;
    }
}
```
