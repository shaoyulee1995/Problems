class Solution {
    List<Integer>[] graph;
    List<List<Integer>> ans;
    boolean[] visited;
    int[] timestamp;
    int timer;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        timestamp = new int[n];
        timer = 0;
        ans = new ArrayList();
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList();
        }
        for(List<Integer> connection: connections){
            int a = connection.get(0),
                b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(-1,0);
        
        return ans;
    }
    private void dfs(int parent, int current){
        visited[current] = true;
        timestamp[current] = timer;
        int curTime = timer;
        timer++;
        
        for(int other: graph[current]){
            if(other == parent){
                continue;
            }
            if(!visited[other]){
                dfs(current, other);
            }
            
            timestamp[current] = Math.min(timestamp[current], timestamp[other]);
            
            if(curTime < timestamp[other]){
                ans.add(Arrays.asList(current, other));
            }
        }
    }
}