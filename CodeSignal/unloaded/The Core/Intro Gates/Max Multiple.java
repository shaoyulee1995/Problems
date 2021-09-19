int maxMultiple(int divisor, int bound) {
    int ans = bound;
    while(ans > 0){
        if(ans%divisor == 0){
            return ans;
        }
        ans--;
    }
    return ans;
}
