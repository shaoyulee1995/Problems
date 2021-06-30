class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] seen = new int[n];
        for(List<Integer> edge: edges){
            seen[edge.get(1)] = 1;
        }
        List<Integer> ans = new ArrayList();
        for(int i = 0; i < seen.length; i++){
            if(seen[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}