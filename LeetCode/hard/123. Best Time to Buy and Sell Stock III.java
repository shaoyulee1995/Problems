class Solution {
    public int maxProfit(int[] prices) {
        int onebuy = Integer.MIN_VALUE,
            onebuyonesell = 0,
            twobuy = Integer.MIN_VALUE,
            twobuytwosell = 0;
        
        for(int price: prices){
            onebuy = Math.max(onebuy, -price);
            onebuyonesell = Math.max(onebuyonesell, onebuy + price);
            twobuy = Math.max(twobuy, onebuyonesell - price);
            twobuytwosell = Math.max(twobuytwosell, twobuy + price);
        }
        
        return Math.max(twobuytwosell, onebuyonesell);
    }
}