# Image Smoother

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of img
    - M as length of img[0]

```java
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++){
            for(int j = 0; j < img[0].length; j++){
                res[i][j] = smooth(img, i, j);
            }
        }
        return res;
    }
    public int smooth(int[][] img, int i, int j){
        int count = 0,
            sum = 0;
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                if(i+x < 0 || i+x == img.length || y+j < 0 || y+j == img[0].length){
                    continue;
                }
                sum += img[x+i][y+j];
                count++;
            }
        }
        return sum/count;
    }
}
```
