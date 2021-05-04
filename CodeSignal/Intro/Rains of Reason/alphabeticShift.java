String alphabeticShift(String s) {
    StringBuilder sb = new StringBuilder();
    for(char c: s.toCharArray()){
        char replaced = (char)(c+1);
        if(replaced >'z'){
            replaced = 'a';
        }
        sb.append(replaced);
    }
    return sb.toString();
}
