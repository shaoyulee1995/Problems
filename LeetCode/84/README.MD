# Largest Rectangle in Histogram

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of heights

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length)? 0: heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()],
                    width = (stack.isEmpty())? i: (i - stack.peek() - 1);
                res = Math.max(res, height * width);
            }
            stack.push(i);
        }
        return res;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of heights

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }
    public int largestRectangleArea(int[] heights, int start, int end){
        if(start > end){
            return 0;
        }
        int minHeight = start;
        for(int i = start; i <= end; i++){
            if(heights[minHeight] > heights[i]){
                minHeight = i;
            }
        }
        int cur = heights[minHeight] * (end - start + 1),
            left = largestRectangleArea(heights, start, minHeight - 1),
            right = largestRectangleArea(heights, minHeight + 1, end);
        return Math.max(cur, Math.max(left, right));
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of heights

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        leftMin[0] = -1;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftMin[p];
            }
            leftMin[i] = p;
        }
        
        rightMin[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) {
                p = rightMin[p];
            }
            rightMin[i] = p;
        }
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = heights[i] * (rightMin[i] - leftMin[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
```