# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of height
```
class Solution {
    public int maxArea(int[] height) {
        int i = 0,
            j = height.length - 1,
            res = 0; 
        while(i < j){
            int tall = Math.min(height[i], height[j]),
                width = j-i;
            res = Math.max(res, tall * width);
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }
}
```