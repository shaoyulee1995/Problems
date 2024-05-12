# Reconstruct Itinerary
# DFS
* Time Complexity: O()
* Space Complexity: O(V+E)
	* V as vertices
    * E as edges
```
class Solution {
    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap();
        res = new LinkedList();
        for(List<String> ticket: tickets){
            map.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }
    
    public void dfs(String city){
        PriorityQueue<String> pq = map.get(city); 
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        res.addFirst(city);
    }
}
```