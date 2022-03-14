# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
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