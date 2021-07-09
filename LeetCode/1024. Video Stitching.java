class Solution {
    public int videoStitching(int[][] clips, int T) {
        int cnt = 0,
            start = 0,
            max = 0;
        while(start < T){
            for(int[] clip: clips){
                if(start >= clip[0]){
                    max = Math.max(max, clip[1]);
                }
            }
            if(start==max){
                return -1;
            }
            cnt++;
            start = max;
        }
        return cnt;
    }
}