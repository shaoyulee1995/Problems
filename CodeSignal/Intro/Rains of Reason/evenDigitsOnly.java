boolean evenDigitsOnly(int n) {
    while(n != 0){
        int digit = n % 10;
        if(digit % 2 == 1){
            return false;
        }
        n /= 10;
    }
    return true;
}
