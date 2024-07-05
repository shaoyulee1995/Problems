# Sort the Matrix Diagonally

# HashMap with PriorityQueue

- Time Complexity: O(MNlog(Min(M,N)))
- Space Complexity: O(MN)
  - M as mat.length
  - N as mat[0].length

```
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                map.computeIfAbsent(i-j, x -> new PriorityQueue<>()).add(mat[i][j]);
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }
}
```

- Time Complexity: O(Max(MD, ND))
- Space Complexity: O(1)
  - M as mat.length
  - N as mat[0].length
  - D as diagonal of matrix

```
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int row = 0; row < mat.length; row++){
            updateDiagonal(mat, row, 0);
        }
        for(int col = 1; col < mat[0].length; col++){
            updateDiagonal(mat, 0, col);
        }
        return mat;
    }

    public void updateDiagonal(int[][] mat, int row, int col){
        int[] cnt = new int[101];
        int x = row,
            y = col;
        while(x < mat.length && y < mat[0].length){
            cnt[mat[x][y]]++;
            x++;
            y++;
        }
        x = row;
        y = col;
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == 0){
                continue;
            }
            while(cnt[i] > 0){
                mat[x][y] = i;
                x++;
                y++;
                cnt[i]--;
            }
        }
    }
}
```
