class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length / 2; j++){
                int temp = image[i][image[i].length - 1 - j];
                image[i][image[i].length - 1 - j] = image[i][j];
                image[i][j] = temp;
            }
        }
        
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++){
                image[i][j] = (image[i][j] == 1)?0:1;
            }
        }
        return image;
    }
}