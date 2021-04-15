class Solution {
    public int minFallingPathSum(int[][] arr) {
        for(int i = 1; i < arr.length; i++){
            int min = Integer.MAX_VALUE,
                secondMin = min;    
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i-1][j] <= min){
                    secondMin = min;
                    min = arr[i-1][j];
                }
                if(arr[i-1][j] < secondMin && arr[i-1][j] > min){
                    secondMin = arr[i-1][j];
                }
            }
            
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i-1][j] == min){
                    arr[i][j] += secondMin;
                }else{
                    arr[i][j] += min;
                }
            }
        }
        int[] lastRow = arr[arr.length - 1];
        int ans = Integer.MAX_VALUE;
        for(int num: lastRow){
            ans = Math.min(ans, num);
        }
        return ans;
    }
}