# Critical Connections in a Network
# Strong Connected Component
* Time Complexity: O(V + E)
* Space Complexity: O(V)
    * V as vertices
    * E as edges
```
class Solution {
    HashMap<Integer, List<Integer>> map;
    List<List<Integer>> res;
    int[] timeStamp;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new HashMap();
        res = new ArrayList();
        timeStamp = new int[n];
        for(List<Integer> connection: connections){
            int x = connection.get(0),
                y = connection.get(1);
            map.computeIfAbsent(x, a -> new ArrayList()).add(y);
            map.computeIfAbsent(y, a -> new ArrayList()).add(x);
        }
        dfs(0, 0, 1);
        return res;
    }

    public void dfs(int parent, int currentNode, int time){
        timeStamp[currentNode] = time;
        for(int neighbor: map.get(currentNode)){
            if(neighbor == parent){
                continue;
            }
            if(timeStamp[neighbor] == 0){
                dfs(currentNode, neighbor, time+1);
            }
            timeStamp[currentNode] = Math.min(timeStamp[currentNode], timeStamp[neighbor]);
            if(time < timeStamp[neighbor]){
                res.add(Arrays.asList(currentNode, neighbor));
            }
        }
    }
}
```