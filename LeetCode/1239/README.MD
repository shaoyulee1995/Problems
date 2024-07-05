# Maximum Length of a Concatenated String with Unique Characters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as size of arr

```
class Solution {
    int res = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, new String());
        return res;
    }

    public void dfs(List<String> arr, int idx, String s){
        if(unique(s)){
            res = Math.max(res, s.length());
        }
        if(!unique(s) || idx == arr.size()){
            return;
        }
        for(int i = idx; i < arr.size(); i++){
            dfs(arr, i+1, s + arr.get(i));
        }
    }

    public boolean unique(String s){
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
            if(cnt[c-'a'] > 1){
                return false;
            }
        }
        return true;
    }
}
```
