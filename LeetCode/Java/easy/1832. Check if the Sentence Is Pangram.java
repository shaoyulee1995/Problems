class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        
        for(char c: sentence.toCharArray()){
            cnt[c-'a']++;
        }
        
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 0){
                return false;
            }
        }
        return true;
    }
}