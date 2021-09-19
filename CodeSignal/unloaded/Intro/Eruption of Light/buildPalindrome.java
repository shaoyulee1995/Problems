String buildPalindrome(String s) {
    String backward = new StringBuilder(s).reverse().toString();
    
    if(backward.equals(s)){
        return s;
    }
    
    for(int i = 0; i < s.length(); i++){
        if((s.substring(0,i)+backward).equals
        (new StringBuilder(s.substring(0,i) + backward).reverse().toString())){
            return (s.substring(0,i)+backward);
        }
    }
    return "";
}
