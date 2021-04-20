int centuryFromYear(int year) {
    int incre = year % 100;
    if(incre != 0){
        return year / 100 + 1;
    }
    return year / 100;
}
