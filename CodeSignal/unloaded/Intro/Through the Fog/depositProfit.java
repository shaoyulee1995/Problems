int depositProfit(int deposit, int rate, int threshold) {
    int cnt = 0;
    double d = deposit;
    while(d < threshold){
        cnt++;
        d = d * (1 + (double)rate/100);
    }
    return cnt;
}
