boolean isMAC48Address(String s) {
    if(s.length() != 17){
        return false;
    }
    String[] parts = s.split("-");
    if(parts.length != 6){
        return false;
    }
    for(String part: parts){
        for(char c: part.toCharArray()){
            if(!isValid(c)){
                return false;
            }
        }
    }
    return true;
}

boolean isValid(char c){
    return (c <='9' && c>='0') || (c >= 'A' && c <='F');
}
