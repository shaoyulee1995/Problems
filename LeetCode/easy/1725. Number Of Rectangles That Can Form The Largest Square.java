class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int cnt = 0, 
            curL = 0, 
            maxL = 0;
        for(int[] row: rectangles){
            curL = Math.min(row[0], row[1]);
            
            if(curL > maxL){
                cnt = 1;
                maxL = curL;
            }else if(curL == maxL){
                cnt++;
            }
        }
        
        return cnt;
    }
}