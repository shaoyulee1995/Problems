* Time Complexity: O(1)
* Space Complexity: O(1)
```
boolean checkPalindrome(String inputString) {
    int L = 0, R = inputString.length() - 1;
    while(L < R){
        if(inputString.charAt(L) != inputString.charAt(R)){
            return false;
        }
        L++;
        R--;
    }
    return true;
}
```