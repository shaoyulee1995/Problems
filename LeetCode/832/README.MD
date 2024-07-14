# Flipping an Image

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of image

```java
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] img: image){
            for(int i = 0; i*2 < img.length; i++){
                int temp = img[i];
                img[i] = img[img.length-1-i];
                img[img.length-1-i] = temp;
            }
            for(int i = 0; i < img.length; i++){
                img[i] = (img[i] == 0)?1:0;
            }
        }
        return image;
    }
}
```
