# Backtrack

## C++
* Time Complexity: IDK
* Space Complexity: IDK 
```
class Solution {
public:
    vector<vector<string>> res;
    vector<vector<string>> solveNQueens(int n) {
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }
    void backtrack(vector<string> &board, int row){
        if(row == board.size()){
            res.push_back(board);
            return;
        }
        int n = board[row].size();
        for(int col = 0; col < n; col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }
    bool isValid(vector<string> &board, int row, int col){
        int n = board.size();
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
};
```

## Java
```
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList();
        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(grid[i], '.');
        }
        dfs(grid, 0);
        return res;
    }
    public void dfs(char[][] grid, int row){
        if(row == grid.length){
            res.add(toAnswer(grid));
            return;
        }
        for(int c = 0; c < grid.length; c++){
            if(valid(grid, row, c)){
                grid[row][c] = 'Q';
                dfs(grid, row+1);
                grid[row][c] = '.';
            }
        }
        
    }
    public boolean valid(char[][] grid, int row, int col){
        for(int i = 0; i < grid.length; i++){
            if(grid[i][col] == 'Q'){
                return false;
            }
        }
        
        for(int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j < grid[0].length; i--, j++){
            if(grid[i][j] == 'Q'){
                return false;
            }
        }
        return true;
        
        
    }
    
    public List<String> toAnswer(char[][] grid){
        List<String> res = new ArrayList();
        for(int i = 0; i < grid.length; i++){
            res.add(new String(grid[i]));
        }
        return res;
    }
}
```