class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            cnt[index]++;
        }
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(cnt[index] == 1){
                return i;
            }
        }
        return -1;
        
    }
}