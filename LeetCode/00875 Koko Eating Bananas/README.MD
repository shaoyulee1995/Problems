# Binary Search
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0, max = 0;
        for(int pile: piles){
            max = Math.max(max, pile);
        }
        while(min < max){
            int mid = min + (max-min)/2;
            double k = 0;
            for(int pile: piles){
                k += Math.ceil((double)pile/mid);
            }
            if(k > h){
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}
```