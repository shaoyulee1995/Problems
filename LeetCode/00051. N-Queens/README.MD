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
    
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';   
            }
        }
        List<List<String>> res = new ArrayList();
        solve(res, chess, 0);
        return res;
    }
    private void solve(List<List<String>> res, char[][] chess, int row){
        if(chess.length == row){
            res.add(construct(chess));
            return;
        }
        for(int col = 0; col < chess.length; col++){
            if(valid(chess, row, col)){
                chess[row][col] = 'Q';
                solve(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }
    private boolean valid(char[][] chess, int row, int col){
        for(int i = 0; i < row; i++){
            if(chess[i][col] == 'Q'){
                return false;
            }
        }
        //going top right
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < chess.length;
            i--, j++){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        //going top left
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--){
            if(chess[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] chess){
        List<String> path = new ArrayList();
        for(int i = 0; i < chess.length; i++){
            path.add(new String(chess[i]));
        }
        return path;
    }
}
```