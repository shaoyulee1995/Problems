# Koko Eating Bananas
# Binary Search
* Time Complexity: O(Plog(M))
* Space Complexity: O(1)
	* P represents length of piles
	* M represents max
```
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1,
            max = Arrays.stream(piles).max().getAsInt();
        while(min < max){
            int k = min + (max-min)/2;
            int eatenHours = getHoursByBanana(piles, k);
            if(eatenHours > h){
                min = k+1;
            }else{
                max = k;
            }
        }
        return min;
    }

    public int getHoursByBanana(int[] piles, int banana){
        int res = 0;
        for(int pile: piles){
            res += Math.ceil((double)pile/banana);
        }
        return res;
    }
}
```