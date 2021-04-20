int shapeArea(int n) {
    int ans = 0;
    int size = n;
    while(n != 0){
         ans += (n);
         n--;
    }
    ans = ans* 4 - 4*size + 1;
    return ans;
}
