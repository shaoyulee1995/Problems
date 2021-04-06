class Solution {
    public int findCenter(int[][] edges) {
        int[] common = new int[2];
        common[0] = edges[0][0];
        common[1] = edges[0][1];
        int ans = 0;
        for(int i = 1; i < edges.length;i++){
            for(int j = 1; j < edges[i].length; j++){
                if(edges[i][j] == common[0]){
                    ans = common[0];
                    return ans;
                }else if(edges[i][j] == common[1]){
                    ans = common[1];
                    return ans;
                }
            }
        }
        return ans;
    }
}