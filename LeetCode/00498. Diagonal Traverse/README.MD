# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* M as length of mat
	* N as length of mat[0]
```
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length,
            n = mat[0].length,
            r = 0,
            c = 0;
        int[] res = new int[m*n];
        for(int i = 0; i < res.length; i++){
            res[i] = mat[r][c];
            if((r+c)%2 == 0){
                if(c == n-1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    c++;r--;
                }
            }else{
                if(r == m-1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;c--;
                }
            }
        }
        return res;
    }
}
```