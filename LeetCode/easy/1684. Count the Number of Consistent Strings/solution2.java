class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] dp = new int[26];
        int cnt = 0;
        for(char c: allowed.toCharArray()){
            dp[c - 'a']++;
        }
        
        for(String str: words){
            boolean valid = true;
            for(char c: str.toCharArray()){
                if(dp[c - 'a'] == 0){
                    valid = false;
                }
            }
            if(valid){
                cnt++;
            }
        }
        return cnt;
    }
}
