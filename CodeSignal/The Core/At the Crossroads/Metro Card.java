int[] metroCard(int lastNumberOfDays) {
    if(lastNumberOfDays == 30){
        return new int[]{31};
    }
    if(lastNumberOfDays == 31){
        return new int[]{28,30,31};
    }
    return new int[]{31};
}
