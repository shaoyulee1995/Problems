boolean isBeautifulString(String s) {
    int[] cnt = new int[26];
    for(char c: s.toCharArray()){
        cnt[c-'a']++;
    }
    
    for(int i = 1; i < cnt.length; i++){
        if(cnt[i] > cnt[i-1]){
            return false;
        }
    }
    return true;
}
