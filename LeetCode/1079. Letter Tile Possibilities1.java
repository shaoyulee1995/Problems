class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for(char c: tiles.toCharArray()){
            cnt[c-'A']++;
        }
        return dfs(cnt);
    }
    
    private int dfs(int[] cnt){
        int sum = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i]==0){
                continue;
            }
            sum++;
            cnt[i]--;
            sum+=dfs(cnt);
            cnt[i]++;
        }
        return sum;
    }
}