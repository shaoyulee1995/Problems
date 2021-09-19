int[][] spiralNumbers(int n) {
    int[][] ans = new int[n][n];
    int top = 0, left = 0, right = n-1, down = n-1;
    for(int num = 1; num <= n*n;){
        for(int i = left; i <= right; i++){
            ans[top][i] = num++;
        }
        top++;
        for(int i = top; i <= down; i++){
            ans[i][right] = num++;
        }
        right--;
        for(int i = right; i >= left; i--){
            ans[down][i] = num++;
        }
        down--;
        for(int i = down; i >= top; i--){
            ans[i][left] = num++;
        }
        left++;
    }
    return ans;
}
