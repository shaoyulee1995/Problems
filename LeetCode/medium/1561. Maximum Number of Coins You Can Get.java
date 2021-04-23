class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left = 0,
            right = piles.length - 2,
            sum = 0;
        while(left < right){
            sum += piles[right];
            right-=2;
            left+=1;
        }
        return sum;
    }
}