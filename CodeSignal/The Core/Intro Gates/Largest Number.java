int largestNumber(int n) {
    int ans = 0;
    while(n != 0){
        ans = ans*10 + 9;
        n--;
    }
    return ans;
}
