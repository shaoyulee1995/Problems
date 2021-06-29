class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        int cnt = 0;
        Arrays.sort(copy);
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != copy[i]){
                cnt++;
            }
        }
        return cnt;
    }
}