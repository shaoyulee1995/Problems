int circleOfNumbers(int n, int firstNumber) {
    int num = firstNumber + (n / 2);
    if(num >= n){
        num -= n;
    }
    return num;
}
