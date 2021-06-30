class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int low = 0; low < s.length(); low ++){
            if(!dp[low]) continue;
            
            for(String word: wordDict){
                int high = low + word.length();
                if(high <= s.length() && s.substring(low, high).equals(word)){
                    dp[high] = true;
                }
            }
        }
        return dp[s.length()];
    }
}