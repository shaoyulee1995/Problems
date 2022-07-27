# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of heights
```
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque();
        stack.push(-1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                max = Math.max(max, heights[stack.pop()] * (i-stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        return max;
    }
}
```
# Divide and Conquer
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(1)
	* N as length of heights
```
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