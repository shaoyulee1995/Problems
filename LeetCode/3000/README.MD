# Maximum Area of Longest Diagonal Rectangle

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of dimensions

```java
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = 0d;
        for(int[] dimension: dimensions){
            double currentDiagonal = getDiagonal(dimension);
            if(currentDiagonal > maxDiagonal){
                maxDiagonal = currentDiagonal;
                maxArea = getArea(dimension);
            }else if(currentDiagonal == maxDiagonal){
                maxArea = Math.max(maxArea, getArea(dimension));
            }
        }
        return maxArea;
    }

    private int getArea(int[] dimension){
        return dimension[0] * dimension[1];
    }


    private double getDiagonal(int[] dimension){
        int width = dimension[0],
            length = dimension[1];
        return Math.sqrt(square(width) + square(length));
    }

    private double square(int x){
        return (double) x*x;
    }
}
```
