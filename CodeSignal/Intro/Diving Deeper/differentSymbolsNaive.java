int differentSymbolsNaive(String s) {
    boolean[] cnt = new boolean[26];
    int res = 0;
    for(char c: s.toCharArray()){
        if(!cnt[c-'a']){
            cnt[c-'a'] = true;
            res++;
        }
    }
    return res;
}
