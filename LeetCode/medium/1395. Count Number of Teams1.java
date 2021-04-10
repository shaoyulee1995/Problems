class Solution {
    public int numTeams(int[] rating) {
    
        
        int result = 0;
        for(int m = 1; m < rating.length - 1; m++){ //mid point
            int left_dec = 0, 
                left_inc = 0,
                right_dec = 0, 
                right_inc = 0;
            
            for(int l = 0; l < m; l++){ //looking left
                if(rating[m]>rating[l]){
                    left_inc++;
                }else{
                    left_dec++;
                }
            }
            
            for(int r = m + 1; r < rating.length; r++){ //looking right
                if(rating[r] > rating[m]){
                    right_inc++;
                }else{
                    right_dec++;
                }
            }
            result += (left_inc * right_inc) + (left_dec * right_dec);
        }
        
        return result;
    }
}