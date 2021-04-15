class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0,
            cooldown = 0,
            buy = Integer.MIN_VALUE;
        
        for(int price: prices){
            buy = Math.max(buy, cooldown - price);
            cooldown = Math.max(cooldown, sell);
            sell = buy + price;
        }
        return Math.max(sell, cooldown);
    }
}