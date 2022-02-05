```
class Solution {
    LinkedList<String> res = new LinkedList();
    HashMap<String, PriorityQueue<String>> map = new HashMap();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }
    public void dfs(String city){
        PriorityQueue<String> paths = map.get(city);
        while(paths!=null && !paths.isEmpty()){
            dfs(paths.poll());
        }
        res.addFirst(city);
    }
}
```