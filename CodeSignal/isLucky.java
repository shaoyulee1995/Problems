boolean isLucky(int n) {
    String s = String.valueOf(n);
    
    String s1 = s.substring(0, s.length()/2),
           s2 = s.substring(s.length()/2, s.length());
    

    
    
    return  valueNumber(s1) == valueNumber(s2);
}


int valueNumber(String s){
    int num = Integer.parseInt(s);
    int sum = 0;
    while(num>0){
        int digit = num%10;
        sum += digit;
        num = num/10;
    }
    
    return sum; 
}


