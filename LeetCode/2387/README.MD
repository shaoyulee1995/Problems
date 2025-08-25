# Median of a Row Wise Sorted Matrix

- Time Complexity: O(NM)
- Space Complexity: O(N)
  - N as length of grid
  - m AS length of grid[0]

```java
class Solution {
    public int matrixMedian(int[][] grid) {
        List<Integer> nums = new ArrayList();
        for(int[] row: grid){
            for(int val: row){
                nums.add(val);
            }
        }
        Collections.sort(nums);
        return nums.get(nums.size()/2);
    }
}
```


```java
class Solution {
    public int matrixMedian(int[][] grid) {
        int total = grid.length * grid[0].length,
            actualMedium = (total+1)/2, 
            min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE;
        for(int[] row: grid){
            min = Math.min(min, row[0]);
            max = Math.max(max, row[row.length-1]);
        }

        while(min < max){
            int mid = min + (max-min)/2,
                count = 0;
            for(int[] row: grid){
                count += countLessThanEqual(row, mid);
            }
            
            if(count < actualMedium){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    private int countLessThanEqual(int[] row, int mid){
        int i = 0,
            j = row.length;
        while(i < j){
            int k = i + (j-i)/2;

            if(row[k] <= mid){
                i = k+1;
            }else{
                j = k;
            }
        }
        return i;
    }
}
```