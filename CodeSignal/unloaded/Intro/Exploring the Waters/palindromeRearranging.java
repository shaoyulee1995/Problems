boolean palindromeRearranging(String inputString) {
    int[] cnt = new int[26];
    
    for(char c: inputString.toCharArray()){
        cnt[c-'a']++;
    }
    
    int spot = 0;
    if(inputString.length() % 2 == 1){
        spot = 1;
    }
    
    
    for(int i = 0; i < 26; i++){
        if(spot < 0){
            return false;
        }
        if(cnt[i] % 2 != 0){
            spot --;
        }
    }
    return true;
}
