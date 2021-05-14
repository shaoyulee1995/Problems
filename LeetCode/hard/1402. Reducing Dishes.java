class Solution {
    public int maxSatisfaction(int[] b) {
        int res = 0;
        int total = 0;
        Arrays.sort(b);
        for(int i = b.length - 1; i >=0 && total > -b[i]; i--){
            total += b[i];
            res += total;
        }
        return res;
    }
}