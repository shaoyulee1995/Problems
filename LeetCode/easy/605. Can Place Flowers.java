class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            boolean left = (i == 0)? true: flowerbed[i-1] == 0,
                    right = (i == flowerbed.length - 1)? true: flowerbed[i+1]==0;
            if(left && right){
                count++;
                flowerbed[i] = 1;
                i++;
            }
        }
        
        return count >= n;
    }
}