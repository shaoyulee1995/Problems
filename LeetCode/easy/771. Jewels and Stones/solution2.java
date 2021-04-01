class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] count = new int[128];
        
        for(char c: jewels.toCharArray()){
            count[c]++;
        }
        int output = 0;
        for(char c: stones.toCharArray()){
            output+=count[c];
        }
        
        return output;
    }
}