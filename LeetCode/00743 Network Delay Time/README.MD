# Graph, Heap
* Time Complexity: O(Tlog(T))
	* T represents length of times
* Space Complexity: O(T+N)
```
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer> > map = new HashMap();
        
        for(int[] time: times){
            map.putIfAbsent(time[0], new HashMap());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[] {0,k});
        
        int res = 0;
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            int[] data = pq.remove();
            int curNode = data[1],
                totalTravel = data[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = totalTravel;
            n--;
            if(n == 0){
                return res;
            }
            
            if(map.containsKey(curNode)){
                for(int next: map.get(curNode).keySet()){
                    pq.add(new int[]{totalTravel + map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0? res: -1;
        
    }
}
```