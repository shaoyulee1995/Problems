class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<int[]> q = new LinkedList();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int length = 0;
        while(!q.isEmpty()){
            int size = q.size();
            length++;
            for(int i = 0; i < size; i++){
                int[] point = q.poll();
                for(int[] dir: directions){
                    int x = dir[0] + point[0],
                        y = dir[1] + point[1];
                    if(x >= 0 && x < mat.length &&
                       y >= 0 && y < mat[0].length){
                        if(mat[x][y] == -1){
                            mat[x][y] = length;
                            q.offer(new int[]{x,y});
                        }
                    }
                }
            }
        }
        return mat;
    }
}