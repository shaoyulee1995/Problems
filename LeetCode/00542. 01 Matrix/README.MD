# BFS
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of mat
	* M as length of mat[0] 
```
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int zeros = 0;
        while(!q.isEmpty()){
            int size = q.size();
            zeros++;
            for(int i = 0; i < size; i++){            
                int[] pos = q.poll();
                for(int[] dir: dirs){
                    int x = dir[0] + pos[0],
                        y = dir[1] + pos[1];
                    if(x >= 0 && y >= 0 && x < mat.length && y < mat[0].length){
                        if(mat[x][y] == -1){
                            mat[x][y] = zeros;
                            q.offer(new int[]{x,y});
                        }
                    }
                }
            }
        }
        return mat;
    }
}
```