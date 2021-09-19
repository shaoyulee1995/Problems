boolean orderCheck = false;
boolean stringsRearrangement(String[] s) {
    boolean[] used = new boolean[s.length];
    sequence(s, "", used, 0);
    return orderCheck;
}

void sequence(String[] s, String prev, boolean[] used, int length){
    if(length == s.length){
        orderCheck = true;
        return;
    }
    
    for(int i = 0; i < s.length; i++){
        if(!used[i] && differ(prev, s[i])){
            used[i] = true;
            sequence(s, s[i], used, length + 1);
            used[i] = false;
        }        
    }
}

boolean differ(String a, String b){
    if(a == ""){
        return true;
    }
    int cnt = 0;
    for(int i = 0; i < a.length(); i++){
        if(a.charAt(i) != b.charAt(i)){
            cnt++;
        }
    }
    return cnt == 1;
}
