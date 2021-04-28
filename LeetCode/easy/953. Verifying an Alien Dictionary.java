class Solution {
    int[] cnt = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < order.length(); i++){
            cnt[order.charAt(i)-'a'] = i;    
        }
        for(int i = 1; i < words.length; i++){
            if(isBig(words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }
    
    private boolean isBig(String first, String second){
        int m = first.length(),
            n = second.length();
        for(int i = 0; i < n && i < m; i++){
            if(first.charAt(i) != second.charAt(i)){
                return cnt[first.charAt(i) - 'a'] > cnt[second.charAt(i)-'a'];
            }
        }
        return m > n;
    }
}