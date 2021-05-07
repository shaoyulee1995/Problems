class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(ans, new ArrayList(), 1, n, k);
        return ans;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int start, int n, int k){
        if(k == 0){
            list.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= n-k+1; i++){ //group all the possible lengths
            temp.add(i);
            backtrack(list, temp, i+1, n, k-1);
            temp.remove(temp.size() - 1);
        }
    }
}