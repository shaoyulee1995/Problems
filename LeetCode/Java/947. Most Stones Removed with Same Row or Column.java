class Solution {
    public int removeStones(int[][] stones) {
        HashSet<int[]> set = new HashSet();
        int numIsland = 0;
        for(int[] stone: stones){
            if(!set.contains(stone)){
                dfs(set, stone, stones);
                numIsland++;
            }
        }
        return stones.length - numIsland;
    }
    private void dfs(HashSet<int[]> set, int[] prev, int[][] stones){
        set.add(prev);
        for(int[] other: stones){
            if(prev[0] == other[0] || prev[1] == other[1]){
                if(!set.contains(other)){
                    dfs(set, other, stones);
                }
            }
        }
    }
}