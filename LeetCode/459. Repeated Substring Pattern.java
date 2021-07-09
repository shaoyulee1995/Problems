class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len / 2; i >= 1; i--){
            if(len%i == 0){
                int numRepeat = len / i;
                String subStr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < numRepeat; j++){
                    sb.append(subStr);
                }
                if(sb.toString().equals(s)){return true;}
            }
        }
        return false;
    }
}