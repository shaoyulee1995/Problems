class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd_move = 0,
            even_move = 0;
        for(int p: position){
            if(p%2 == 0){
                even_move++;
            }else{
                odd_move++;
            }
        }
        return Math.min(even_move, odd_move);
    }
}