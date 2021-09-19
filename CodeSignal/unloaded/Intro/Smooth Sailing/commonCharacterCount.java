int commonCharacterCount(String s1, String s2) {
    int[] cnt1 = new int[26],
          cnt2 = new int[26];

    for(char c: s1.toCharArray()){
        cnt1[c-'a']++;
    }
    
    for(char c: s2.toCharArray()){
        cnt2[c-'a']++;
    }
    
    int ans = 0;
    for(int i = 0; i < 26; i++){
        ans += Math.min(cnt1[i], cnt2[i]);
    }
    return ans;
}
