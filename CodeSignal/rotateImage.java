int[][] rotateImage(int[][] a) {
    if(a.length == 0){
        return new int[0][0];
    }
    
    for(int i = 0; i < a.length; i++){
        for(int j = i; j < a[i].length; j++){
            int temp = a[i][j];
            a[i][j] = a[j][i];
            a[j][i] = temp;
        }
    }
    
    for(int i = 0; i < a.length; i++){
        for(int j = 0; j < a[i].length / 2; j++){
            int temp = a[i][j];
            a[i][j] = a[i][a.length - 1 -j];
            a[i][a.length - 1 -j] = temp;
        }
    }
    return a;
    
}
