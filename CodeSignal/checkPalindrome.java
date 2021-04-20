boolean checkPalindrome(String inputString) {
    int start = 0,
        end = inputString.length() - 1;
        
    while(start < end){
        if(inputString.charAt(start) != inputString.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}
