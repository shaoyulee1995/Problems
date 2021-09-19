int lateRide(int n) {
    int hrs = n / 60,
        minutes = n % 60;
    int ans = 0;
    while(hrs != 0){
        ans += hrs%10;
        hrs /= 10;
    }
    while(minutes != 0){
        ans += minutes %10;
        minutes /= 10;
    }
    return ans;
}
