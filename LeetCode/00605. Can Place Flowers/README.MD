# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of flowerbed
```
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        for(int i = 0; i< flowerbed.length; i++){
            if(flowerbed[i] == 1){
                continue;
            }

            boolean left = (i == 0)? true: (flowerbed[i-1] == 0),
                    right = (i == flowerbed.length-1)? true: (flowerbed[i+1] == 0);
            if(left && right){
                n--;
                flowerbed[i] = 1;
            }
            if(n == 0){
                return true;
            }
        }
        return false;
    }
}
```