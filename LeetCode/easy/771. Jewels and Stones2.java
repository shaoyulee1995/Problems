class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] cnt = new int['z'-'A'+1];
        for(char c: stones.toCharArray()){
            cnt[c-'A']++;
        }
        
        int res = 0;
        for(char c: jewels.toCharArray()){
            res += cnt[c-'A'];
        }
        return res;
    }
}