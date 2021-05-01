class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        dfs(ans, n, n, "");
        return ans;
    }
    
    private void dfs(List<String> list, int left, int right, String s){
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(list, left - 1, right, s + "(");
        }
        if(right > 0){
            dfs(list, left, right - 1, s + ")");
        }
        if(left == 0 && right == 0){
            list.add(s);
            return;
        }
    }
}