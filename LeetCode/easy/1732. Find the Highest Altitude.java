class Solution {
    public int largestAltitude(int[] gain) {
        int cur_alt = 0,
            max_alt = 0;
        
        for(int i = 0; i < gain.length; i++){
            cur_alt += gain[i];
            max_alt = Math.max(cur_alt, max_alt);
        }
        
        return max_alt;
    }
}