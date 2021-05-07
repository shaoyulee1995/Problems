class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        //row is str1, col is str2
        lcs(str1, str2, dp);
        
        int i = str1.length(),
            j = str2.length();
        
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){ //top > left, (move top) so pick the row element(which is str1 index)
                    sb.append(str1.charAt(i-1));
                    i--;
                }else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){ //rest of stuffs
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){ //rest of stuffs
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.toString();
        
    }
    private void lcs(String s1, String s2, int[][] dp){
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
    }
}