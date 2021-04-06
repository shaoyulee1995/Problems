class Solution {
    public int findLucky(int[] arr) {
        int[] res = new int[501];
        
        for(int item: arr){
            res[item]++;
        }
        
        
        for(int i = res.length - 1; i > 0; i--){
            if(res[i]== i){
                return i;
            }
        }
        return -1;
    }
}