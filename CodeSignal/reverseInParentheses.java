String reverseInParentheses(String inputString) {
    int firstP = inputString.lastIndexOf("("),
        lastP = inputString.indexOf(")", firstP);
        
    while(firstP != -1){
        String reverse = 
        
        new StringBuilder(inputString.substring(firstP + 1, lastP)).reverse().toString(), 
        
               beforeReverse = inputString.substring(0, firstP),
               afterReverse = inputString.substring(lastP + 1);
        inputString = beforeReverse + reverse + afterReverse;       
        firstP = inputString.lastIndexOf("(");
        lastP = inputString.indexOf(")", firstP);
    }
    
    return inputString;
}
