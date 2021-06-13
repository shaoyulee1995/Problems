class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer> > ans = new ArrayList();
        List<Integer> temp = new ArrayList();
        temp.add(0);
        helper(ans, temp, graph, 0);
        return ans;
    }
    
    
    private void helper(List<List<Integer> > ans, List<Integer> temp, int[][] graph, int cur){
        if(cur == graph.length - 1){
            ans.add(new ArrayList(temp));
            return;
        }
        for(int next: graph[cur]){
            temp.add(next);
            helper(ans, temp, graph, next);
            temp.remove(temp.size() - 1);
        }
    }
}