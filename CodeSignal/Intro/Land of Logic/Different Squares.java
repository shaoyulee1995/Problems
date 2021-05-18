int differentSquares(int[][] matrix) {
    HashSet<String> set = new HashSet();
    
    for(int i = 0; i + 1< matrix.length; i++){
        for(int j = 0; j + 1< matrix[i].length; j++){
            set.add(new String(matrix[i][j] + "," + 
                                matrix[i][j+1]+ "," +
                                matrix[i+1][j]+ "," +
                                matrix[i+1][j+1]));
        }
    }
    return set.size();
}
