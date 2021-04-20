boolean sudoku2(char[][] grid) {

    for(int i = 0; i < grid.length; i++){
        if(checkRow(grid, i) == false){
            return false;
        }
    }
    
    
    for(int i = 0; i < grid[0].length; i++){
        if(checkCol(grid, i) == false){
            return false;
        }
    }
    
    for(int i = 0; i < grid.length; i+=3){
        for(int j = 0; j < grid[i].length; j+=3){
            if(checkBox(grid, i, j) == false){
                return false;
            }
        }
    }

    return true;
}


boolean checkRow(char[][] grid, int row){
    HashSet<Character> set = new HashSet();
    for(int i = 0; i < grid.length; i++){
        char cur = grid[row][i];
        if(cur == '.'){
            continue;
        }
        
        if(!set.contains(cur)){
            set.add(cur);
        }else{
            return false;
        }
    }
    return true;
}

boolean checkCol(char[][] grid, int col){
    
    HashSet<Character> set = new HashSet();
    for(int i = 0; i < grid.length; i++){
        char cur = grid[i][col];
            if(cur == '.'){
                continue;
            }
        if(!set.contains(cur)){
            set.add(cur);
        }else{
            System.out.println("false in col");
            return false;
        }
    }
    return true;
}

boolean checkBox(char[][] grid, int row, int col){
    HashSet<Character> set = new HashSet();
    for(int i = row; i < row + 3; i++){
        for(int j = col; j < col + 3; j++){
            char cur = grid[i][j];
            if(cur =='.'){
                continue;
            }
            if(!set.contains(cur)){
                set.add(cur);
            }else{
            System.out.println("false in box");
                return false;
            }
        }
    }
    return true;
}
