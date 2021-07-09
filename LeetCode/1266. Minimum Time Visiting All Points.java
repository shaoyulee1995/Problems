class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        
        for(int i = 0; i < points.length-1; i++){
            int x = Math.abs(points[i+1][0] - points[i][0]),
                y = Math.abs(points[i+1][1] - points[i][1]);
            res += Math.max(x,y);
        }
        
        return res;
    }
}