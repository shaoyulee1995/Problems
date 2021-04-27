class Solution {
    public int orangesRotting(int[][] grid) {
        HashSet<String> fresh = new HashSet();
        HashSet<String> rotten = new HashSet();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh.add("" + i + j);
                }else if(grid[i][j] == 2){
                    rotten.add("" + i + j);
                }
            }
        }
        int minutes = 0;
        while(fresh.size() > 0){
            HashSet<String> infected = new HashSet();
            
            int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
            
            for(String r: rotten){
                int i = r.charAt(0) - '0',
                    j = r.charAt(1) - '0';
                for(int[] direction: directions){
                    int nextI = i + direction[0],
                        nextJ = j + direction[1];
                    if(fresh.contains("" + nextI + nextJ)){
                        infected.add("" + nextI + nextJ);
                        fresh.remove("" + nextI + nextJ);
                    }
                }
            }
            
            if(infected.size() == 0){
                return -1;
            }
            rotten = infected;
            minutes++;
        }
        return minutes;
    }
}