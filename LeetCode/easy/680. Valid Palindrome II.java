class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, 
            right = s.length() - 1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++; right--;
            }else{
                return validHelper(s, left + 1, right) ||
                       validHelper(s, left, right - 1);
            }
        }
        return true;
    }
    
    public boolean validHelper(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}