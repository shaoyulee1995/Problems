# Letter Tile Possibilities

# Backtrack Cunting Array

- Time Complexity: O(N)
- Space Complexity: O(26)
  - N as length of tiles

```java
class Solution{

    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for(char c: tiles.toCharArray()){
            cnt[c-'A']++;
        }
        return dfs(cnt);
    }
    public int dfs(int[] cnt){
        int res = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] > 0){
                res++;
                cnt[i]--;
                res += dfs(cnt);
                cnt[i]++;
            }
        }
        return res;
    }
}
```

# Backtrack HashSet

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of tiles

```java
class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet();
        boolean[] visited = new boolean[tiles.length()];
        dfs(set, visited, tiles, new StringBuilder());
        return set.size() - 1;
    }

    public void dfs(HashSet<String> set, boolean[] visited, String tiles, StringBuilder sb){
        set.add(sb.toString());
        for(int i = 0; i < tiles.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(tiles.charAt(i));
                dfs(set, visited, tiles, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
```
