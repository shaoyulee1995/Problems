int circleOfNumbers(int n, int firstNumber) {
    int half = n / 2;
    if(firstNumber + half >= n){
        return (firstNumber + half ) % n;
    }
    return firstNumber + half;
}
