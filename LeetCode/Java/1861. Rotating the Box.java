class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] rotated = rotate(box);
        gravityFall(rotated);
        return rotated;
    }
    
    private void gravityFall(char[][] box){
        int m = box.length,
            n = box[0].length;
        
        for(int col = 0; col < n; col++){
            int lastOpen = m - 1;
            for(int row = m - 1; row >= 0; row--){
                char c = box[row][col];
                if(c == '.'){
                    continue;
                }
                if(c == '*'){
                    lastOpen = row - 1;
                    continue;
                }
                if(c =='#'){
                    box[row][col] = '.';
                    box[lastOpen][col] = '#';
                    lastOpen--;
                }
            }
        }
    }
    public char[][] rotate(char[][] box){
        char[][] rotated = new char[box[0].length][box.length];
        for(int i = 0, c = box.length - 1; i < box.length;c--, i++){
            for(int j = 0, r = 0; j < box[0].length;r++, j++){
                rotated[r][c] = box[i][j];
                
            }
        }
        return rotated;
    }
}