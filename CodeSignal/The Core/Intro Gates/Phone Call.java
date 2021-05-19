int phoneCall(int min1, int min2_10, int min11, int s) {
    int ans = 0;
    if(s-min1>=0){
        ans++;
        s-=min1;
    }
    if(s-min1<0){
        return ans;
    }
    for(int i = 0; i < 9 && s-min2_10>=0; i++){
        s-=min2_10;
        ans++;
    }
    if(s-min2_10<0){
        return ans;
    }
    while(s-min11>= 0){
        s-=min11;
        ans++;
    }
    return ans;
}
