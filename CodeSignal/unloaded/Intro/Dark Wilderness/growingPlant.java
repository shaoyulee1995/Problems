int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
    int height = 0;
    int day = 0;
    while(height < desiredHeight){
        day++;
        height+=upSpeed;
        if(height >= desiredHeight){
            break;
        }
        height-=downSpeed;
    }
    return day;
}
