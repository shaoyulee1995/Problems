class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absent++;
            }
            if(absent == 2){
                return false;
            }
            if(i != 0 && i != s.length() - 1){
                char prev = s.charAt(i-1),
                     next = s.charAt(i+1);
                if(c =='L' && prev =='L' && next =='L'){
                    return false;
                }
            }
        }
        return true;
    }
}