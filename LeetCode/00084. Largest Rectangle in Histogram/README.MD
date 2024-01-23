# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of heights
```
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                res = Math.max(res, heights[stack.pop()] * (i-1-stack.peek()));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            res = Math.max(res, heights[stack.pop()] * (heights.length-1-stack.peek()));
        }
        return res;
    }
}
```
# Divide and Conquer
* Time Complexity: O(NlogN)
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