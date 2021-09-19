int digitDegree(int n) {
    if(n/10 == 0){
        return 0;
    }
    int num = 0;
    while(n != 0){
        num += n%10;
        n /= 10;
    }
    return 1 + digitDegree(num);
}
