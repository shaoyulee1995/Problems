# Trapping Rain Water
# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of height
```
class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1,
            MaxL = 0, MaxR = 0, 
            res = 0;
        while(i < j){
            MaxL = Math.max(MaxL, height[i]);
            MaxR = Math.max(MaxR, height[j]);
            if(MaxL < MaxR){
                res += MaxL - height[i];
                i++;
            }else{
                res += MaxR - height[j];
                j--;
            }
        }
        return res;
    }
}
```
# 2 Arrays
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of height
```
class Solution {
    public int trap(int[] height) {
        int[] l = new int[height.length],
              r = new int[height.length];
        l[0] = height[0];
        r[r.length-1] = height[height.length-1];
        for(int i = 1; i < l.length; i++){
            l[i] = Math.max(l[i-1], height[i]);
        }
        for(int i = height.length - 2; i >= 0; i--){
            r[i] = Math.max(r[i+1], height[i]);
        }
        int res = 0;
        for(int i = 0; i < height.length; i++){
            res += Math.min(l[i], r[i]) - height[i];
        }
        return res;
    }
}
```
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of height
```
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int i = 0, 
            res = 0; 
        while(i < height.length){
            if(stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
            }else{
                int pre = stack.pop();
                if(!stack.isEmpty()){
                    int minWall = Math.min(height[i], height[stack.peek()]);
                    res += (minWall - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return res;
    }
}
```