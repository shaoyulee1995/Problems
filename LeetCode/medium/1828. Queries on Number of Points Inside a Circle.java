class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int index = 0;
        for(int[] circle: queries){
            int x = circle[0],
                y = circle[1],
                r = circle[2],
                cnt = 0;
            for(int[] point: points){
                if(circleValid(x,y,r,point)){
                    cnt++;
                }
            }
            res[index++] = cnt;
        }
        System.gc();
        return res;
    }
    private boolean circleValid(int x1, int y1, int r, int[] points){
        int x2 = points[0],
            y2 = points[1];
        return (int)Math.pow(x1 - x2, 2) + (int)Math.pow(y1 - y2, 2) <= (int)Math.pow(r, 2);        
    }
}