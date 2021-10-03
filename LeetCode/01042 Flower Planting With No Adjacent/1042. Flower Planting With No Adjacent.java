class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet());
        }
        
        for(int[] path: paths){
            int x = path[0] - 1,
                y = path[1] - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int[] color = new int[5];
            for(int num: graph.get(i)){
                color[ans[num]] = 1;
            }
            
            for(int c = 4; c >= 1; c--){
                if(color[c] != 1){
                    ans[i] = c;
                }        
            }
        }
        return ans;
    }
}