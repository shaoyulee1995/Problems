# Koko Eating Bananas

- Time Complexity: O(PlogM)
- Space Complexity: O(1)
  - P represents length of piles
  - M represents max

```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE,
            res = 0;
        for(int pile: piles){
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }
        while(min < max){
            int k = min + (max-min)/2;
            int consumeHours = getConsumeHours(piles, k);
            if(consumeHours > h){
                min = k+1;
            }else{
                max = k;
            }
        }
        return min;
    }

    private int getConsumeHours(int[] piles, int k){
        int res = 0;
        for(int pile: piles){
            res += Math.ceil((double)pile/k);
        }
        return res;
    }
}
```
