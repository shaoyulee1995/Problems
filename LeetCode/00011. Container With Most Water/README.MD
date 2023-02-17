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
            int h = Math.min(height[j], height[i]), 
                b = j-i;
            res = Math.max(res, h*b);
            if(height[j] > height[i]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
```