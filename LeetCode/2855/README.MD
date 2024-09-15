# Minimum Right Shifts to Sort the Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - P as length of nums

```java
class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        if(nums.size() == 1){
            return 0;
        }
        int peakIndex = -1;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) > nums.get((i+1)%nums.size())){
                if(peakIndex == -1){
                    peakIndex = i;
                }else{
                    return -1;
                }
            }
        }
        return nums.size() - peakIndex - 1;
    }
}
```