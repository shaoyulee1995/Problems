boolean arithmeticExpression(int a, int b, int c) {
    if(a+b == c){
        return true;
    }
    if(a-b == c){
        return true;
    }
    if(a*b == c){
        return true;
    }
    if(a/b == c && a%b == 0){
        return true;
    }
    return false;
}
