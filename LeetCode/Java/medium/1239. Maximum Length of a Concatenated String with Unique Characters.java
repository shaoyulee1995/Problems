class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        dfs("", 0, arr);
        return max;
    }
    public void dfs(String concatenations , int index, List<String> arr){
        if(unique(concatenations)){
            max = Math.max(max, concatenations.length());
        }
        if(!unique(concatenations) || index == arr.size()){
            return;
        }
        for(int i = index; i < arr.size(); i++){
            dfs(concatenations + arr.get(i), i + 1, arr);
        }
    }
    public boolean unique(String s){
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            if(cnt[c-'a']++ > 0){
                return false;
            }
        }
        return true;
    }
}