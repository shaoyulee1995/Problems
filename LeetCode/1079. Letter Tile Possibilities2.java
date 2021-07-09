class Solution {
    public int numTilePossibilities(String tiles) {
        if(tiles.length() == 0){
            return 0;
        }
        HashSet<String> set = new HashSet();
        for(int i = 0; i < tiles.length(); i++){   
            dfs(set, tiles, new StringBuilder(), new boolean[tiles.length()]);
        }
        return set.size();
    }
    private void dfs(HashSet<String> set, String tiles, StringBuilder sb,  boolean[] visited){
        for(int i = 0; i < tiles.length(); i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            sb.append(tiles.charAt(i));
            set.add(sb.toString());
            
            dfs(set, tiles, sb, visited);
            visited[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}