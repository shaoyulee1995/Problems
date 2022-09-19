# Matrix
* Time Complexity: O(NM)
* Space Complexity: O(NM)
	* N as length of mat
	* M as length of mat[0]
```
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length,
            m = mat[0].length,
            r = 0,
            c = 0;
        int[] res = new int[n*m];
       
        for(int i = 0; i < res.length; i++){
            res[i] = mat[r][c];
            if((r+c)%2 == 0){
                if(c == m-1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r == n-1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
```