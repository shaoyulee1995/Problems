class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        for(String str: words){
            boolean valid = true;
            for(char c: str.toCharArray()){
                if(!allowed.contains(String.valueOf(c))){
                    valid = false;
                    break;
                }
            }
            if(valid){
                cnt++;
            }
        }
        return cnt;
    }
}