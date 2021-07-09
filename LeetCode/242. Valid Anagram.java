class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] cnt1 = new int[26];
        for(char c: s.toCharArray()){
            cnt1[c-'a']++;
        }
        for(char c: t.toCharArray()){
            if(--cnt1[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}