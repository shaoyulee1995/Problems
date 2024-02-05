# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of height
```
class Solution {
    public int maxArea(int[] height) {
        int i = 0,
            j = height.length-1,
            res = 0;
        while(i < j){
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j-i));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
```