class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        
        ans[0] = 0;
        
        for(int i = 1; i < n; i++){
            ans[i] = i;
            ans[0] -= i;
        }
        return ans;
    }
}