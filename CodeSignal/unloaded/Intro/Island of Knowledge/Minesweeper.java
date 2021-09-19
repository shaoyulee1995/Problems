int[][] minesweeper(boolean[][] matrix) {
    int[][] res = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            res[i][j] = friends(matrix, i, j);
        }
    }
    return res;
}


int friends(boolean[][] m, int i, int j){
    int cnt = 0;
    for(int x = i - 1; x <= i+ 1; x++){
        if(x < 0 || x >= m.length){
            continue;
        }
        for(int y = j - 1; y <= j+1; y++){
            if(y < 0 || y >= m[i].length){
                continue;
            }
            if(x==i && y==j){
                continue;
            }
            if(m[x][y] == true){
                cnt++;
            }
        }
    }
    return cnt;
}
