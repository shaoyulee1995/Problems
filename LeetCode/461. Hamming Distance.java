class Solution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int cnt = 0;
        while(result > 0){
            cnt += result&1;
            result >>= 1;
        }
        return cnt;
    }
}
