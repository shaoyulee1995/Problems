int[][] boxBlur(int[][] image) {
    int[][] res = new int[image.length - 2][image[0].length - 2];
    for(int i = 1; i < image.length - 1; i++){
        for(int j = 1; j < image[0].length - 1; j++){
            res[i-1][j-1] = centerValue(image, i, j);
        }
    }
    return res;
}
int centerValue(int[][] image, int centerX, int centerY){
    int sum = 0;
    for(int i = centerX - 1; i <= centerX + 1; i++){
        for(int j = centerY - 1; j <= centerY + 1; j++){
            sum += image[i][j];
        }
    }
    return (int)(sum / 9);
}