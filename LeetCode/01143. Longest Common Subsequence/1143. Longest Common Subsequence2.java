class Solution {
    
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0; j < text2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return recursionHelper(text1, text1.length(), text2, text2.length());
    }
    
    public int recursionHelper(String text1, int pos1, String text2, int pos2){
        if(pos1 == 0 || pos2 == 0){                             //base case
            return 0;
        }
        if(dp[pos1 - 1][pos2 - 1] != -1){                       //been through this 
            return dp[pos1 - 1][pos2 - 1];
        }
        if(text1.charAt(pos1 - 1) == text2.charAt(pos2 - 1)){   //add one to diagonal
            dp[pos1 - 1][pos2 - 1] = 1 + recursionHelper(text1, pos1 - 1, text2, pos2 -1);
            return dp[pos1 -1][pos2 -1];
        }else{                                                  //either pick the max from above or left
            dp[pos1 - 1][pos2 - 1] = Math.max(recursionHelper(text1, pos1 - 1, text2, pos2),
                                             recursionHelper(text1, pos1, text2, pos2 -1));
            return dp[pos1 - 1][pos2 - 1];
        }
    } 
}