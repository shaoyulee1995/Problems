class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsCnt = new int[26];
        for(char c: chars.toCharArray()){
            charsCnt[c-'a']++;
        }
        
        int ans = 0;
        for(String word: words){
            if(valid(charsCnt.clone(), word)){
                ans += word.length();
            }
        }
        return ans;
        
    }
    
    public boolean valid(int[] cnt, String s){
        for(char c: s.toCharArray()){
            if(--cnt[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}