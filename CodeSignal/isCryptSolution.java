boolean isCryptSolution(String[] crypt, char[][] solution) {
    //convert every character to integer
    for(int i = 0; i < crypt.length; i++){
        for(char[] c: solution){
            crypt[i] = crypt[i].replace(c[0], c[1]);
        }
    }
    
    for(int i = 0; i < crypt.length; i++){
        if(crypt[i].charAt(0) == '0' && crypt[i].length() != 1){
            return false;
        }
    }
    
    long[] numbers = new long[crypt.length];
    
    for(int i = 0; i < crypt.length; i++){
        numbers[i] = Long.parseLong(crypt[i]);
    }
    
    return numbers[0] + numbers[1] == numbers[2];
}
