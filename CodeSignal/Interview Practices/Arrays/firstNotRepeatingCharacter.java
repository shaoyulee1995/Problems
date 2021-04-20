char firstNotRepeatingCharacter(String s) {
    int[] dp = new int[26];
    
    for(char c: s.toCharArray()){
        dp[c-'a']++;
    }
    char c = '_';
    
    for(int i = 0; i < s.length();i++){
        char current = s.charAt(i);
        if(dp[current-'a'] == 1){
            return current;
        }
    }
    return '_';
}
