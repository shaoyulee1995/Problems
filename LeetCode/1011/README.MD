# Capacity To Ship Packages Within D Days

- Time Complexity: O(Nlog(Sum(W))
- Space Complexity: O(1)

```
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for(int weight: weights){
            min = Math.max(min, weight);
            max += weight;
        }

        while(min < max){
            int mid = min + (max-min)/2;
            int needs = 1, cur = 0;
            for(int weight: weights){
                if(cur + weight > mid){
                    needs++;
                    cur = 0;
                }
                cur += weight;
            }
            if(needs > days){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}
```
