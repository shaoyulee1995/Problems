String longestDigitsPrefix(String s) {
    StringBuilder sb = new StringBuilder();
    for(char c: s.toCharArray()){
        if(c >= '0' && c<='9'){
            sb.append(c);
            continue;
        }
        break;
    }
    return sb.toString();
}
