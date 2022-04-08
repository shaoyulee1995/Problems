# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of height
```
class Solution {
    public int maxArea(int[] height) {
        int i = 0,
            j = height.length - 1,
            area = 0;
        while(i < j){
            area = Math.max(area, (j-i)*Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return area;
    }
}
```