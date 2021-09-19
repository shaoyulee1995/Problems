boolean sudoku(int[][] grid) {
    for(int i = 0; i < grid.length; i++){
        if(!rowCheck(grid, i)){
            return false;
        }
        if(!colCheck(grid, i)){
            return false;
        }
    }
    for(int i = 0; i < grid.length; i+=3){
        for(int j = 0; j < grid[0].length; j+=3){
            if(!boxCheck(grid, i, j)){
                System.out.println("box");
                return false;
            }
        }
    }
    return true;
}

boolean rowCheck(int[][] grid, int row){
    HashSet<Integer> set = new HashSet();
    for(int i = 0; i < grid.length; i++){
        if(!set.add(grid[row][i])){
            return false;
        }
    }
    return true;
}

boolean colCheck(int[][] grid, int col){
    HashSet<Integer> set = new HashSet();
    for(int i = 0; i < grid.length; i++){
        if(!set.add(grid[i][col])){
            return false;
        }
    }
    return true;
}

boolean boxCheck(int[][] grid, int row, int col){
    HashSet<Integer> set = new HashSet();
    for(int i = row; i < row+3; i++){
        for(int j = col; j < col+3; j++){
            if(!set.add(grid[i][j])){
                return false;
            }
        }
    }
    return true;
}
