# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as size of arr
```
class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }
    public void dfs(List<String> arr, int index, String s){
        if(unique(s)){
            max = Math.max(max, s.length());
        }
        if(!unique(s) || arr.size() == index){
            return;
        }
        for(int i = index; i < arr.size(); i++){
            dfs(arr, i+1, s + arr.get(i));
        }
    }
    public boolean unique(String s){
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            if(cnt[c-'a'] ++ > 0){
                return false;
            }
        }
        return true;
    }
}
```