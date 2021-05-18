String longestWord(String text) {
    StringBuilder sb = new StringBuilder();
    String longest = "";
    int cnt = 0, max = 0;
    for(char c: text.toCharArray()){
        if(c >= 'a' && c <='z' || c >='A' && c <='Z'){
            sb.append(c);
            cnt++;
        }else{
            if(cnt > max){
                max = cnt;
                longest = sb.toString();
            }
            sb.setLength(0);
            cnt = 0;
        }
    }
    if(cnt != 0){
        if(cnt > max){
            max = cnt;
            longest = sb.toString();
        }
    }
    return longest;
}
