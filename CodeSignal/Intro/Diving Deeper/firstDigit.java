char firstDigit(String s) {
    for(char c: s.toCharArray()){
        if(c >= '0' && c <='9'){
            return c;
        }
    }
    return '0';
}
