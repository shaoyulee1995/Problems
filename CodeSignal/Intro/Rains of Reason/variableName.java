boolean variableName(String name) {
    if(name.charAt(0)<='9' && name.charAt(0) >='0'){
        return false;
    }
    for(char c: name.toCharArray()){
        if((c >= 'a' && c <='z') || c == '_' || (c>='0' && c<='9') ||(c >= 'A' && c <='Z')){
            continue;
        }
        return false;
    }
    return true;
}
//Correct variable names consist only of English letters, digits and underscores and they can't start with a digit.