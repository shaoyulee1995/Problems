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
    List<List<String>> paths = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0);
        return paths;
    }
    public void dfs(char[][] board, int row){
        if(row == board.length){
            paths.add(build(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(!isValid(board, row, col)){
                continue;
            }
            board[row][col] = 'Q';
            dfs(board, row + 1);
            board[row][col] = '.';
        }
    }
    public boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }    
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> build(char[][] board){
        List<String> path = new ArrayList();
        for(int i = 0; i < board.length; i++){
            path.add(new String(board[i]));
        }
        return path;
    }
}
```