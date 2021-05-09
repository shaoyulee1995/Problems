String lineEncoding(String s) {
    
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while(j<s.length()){
        if(s.charAt(i) == s.charAt(j)){
            j++;
        }else{
            if(((j-1)-i+1) != 1){
                sb.append((j-1)-i+1);
            }
            sb.append(s.charAt(i));
            i = j;
        }
    }
    if(((j-1)-i+1) != 1){
        sb.append((j-1)-i+1);
    }
    sb.append(s.charAt(i));
    
    return sb.toString();
}
