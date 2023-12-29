# Strongly Connected Components
* Time Complexity: O(V + E)
* Space Complexity: O(V)
    * V as vertices
    * E as edges
```
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] inDegree = new int[n+1];
        int[] weight = new int[n+1];
        for(int[] relation: relations){
            int a = relation[0],
                b = relation[1];
            map.computeIfAbsent(a, x -> new ArrayList<>()).add(b);
            inDegree[b]++;
        }
        for(int i = 0; i< time.length; i++){
            weight[i+1] = time[i];
        }
        Queue<Integer> queue = new LinkedList();
        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor: map.getOrDefault(node, new ArrayList<>())){
                weight[neighbor] = Math.max(weight[neighbor], weight[node] + time[neighbor-1]);
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return Arrays.stream(weight).max().getAsInt();
    }
}
```