class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row: image){
            for(int i = 0; i * 2 < row.length; i++){
                int temp = row[i];
                row[i] = row[row.length-i-1];
                row[row.length-1-i] = temp;
            }
            
            for(int i = 0; i < row.length; i++){
                if(row[i] == 0){
                    row[i] = 1;
                }else{
                    row[i] = 0;   
                }
            }
        }
        return image;
    }
}