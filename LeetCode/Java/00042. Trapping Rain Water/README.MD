Time Complexity: O(N)
<br />
Space Complexity: O(1)
```
class Solution {
    public int trap(int[] height) {
        int ans = 0,
            leftMax = 0,
            rightMax = 0,
            i = 0,
            j = height.length - 1;
        while(i < j){
            if(height[i] <= height[j]){
                //update max if possible
                //add remaing water
                //increase pointer
                if(leftMax < height[i]){
                    leftMax = height[i];
                }else{
                    ans += (leftMax - height[i]);
                }
                i++;
            }else{
                if(rightMax < height[j]){
                    rightMax = height[j];
                }else{
                    ans += (rightMax - height[j]);
                }
                j--;
            }
        }
        return ans;
    }
}
```