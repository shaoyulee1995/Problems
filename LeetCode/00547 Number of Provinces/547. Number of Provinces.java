class Solution {
    public int findCircleNum(int[][] m) {
        int cnt = 0;
        boolean[] visited = new boolean[m.length];
        for(int row = 0; row < m.length; row++){
            if(!visited[row]){
                cnt++;
                dfs(m, visited, row);
            }
        }
        return cnt;
    }
    
private void dfs(int[][] m, boolean[] visited, int me){
        if(me > m.length || me < 0){
            return;
        }
        for(int other = 0; other < m.length; other++){
            if(m[me][other] == 1 && !visited[other]){
                visited[other] = true;
                dfs(m, visited, other);
            }
        }
    }
}