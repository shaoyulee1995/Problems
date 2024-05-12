# Subrectangle Queries
# Matrix
* Time Complexity: O(RC)
* Space Complexity: O(NM)
	* R as row2-row1
	* C as col2-col1
	* N as length of rectangle
	* M as length of rectangle[0]
```
class SubrectangleQueries {
    int[][] dp;
    public SubrectangleQueries(int[][] rectangle) {
        dp = rectangle;
    }
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                dp[i][j] = newValue;
            }
        }
    }
    public int getValue(int row, int col) {
        return dp[row][col];
    }
}
```
```
/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
```