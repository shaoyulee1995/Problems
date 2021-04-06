class Solution {
    public boolean isPalindrome(int x) {
        String val = String.valueOf(x);
        int start = 0,
            end = val.length() - 1;
        while(start < end){
            if(val.charAt(start++) != val.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}