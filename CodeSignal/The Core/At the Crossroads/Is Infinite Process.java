boolean isInfiniteProcess(int a, int b) {
    while(a!=b){
        if(a > b){
            return true;    
        }
        a++;b--;
    }
    return false;
}
