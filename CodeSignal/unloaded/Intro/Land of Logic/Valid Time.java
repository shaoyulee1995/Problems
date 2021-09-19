boolean validTime(String time) {
    String[] s = time.split(":");
    int hrs = Integer.parseInt(s[0]),
        minutes = Integer.parseInt(s[1]);
    if(!(hrs >= 0 && hrs <= 23)){
        return false;
    }
    if(!(minutes >= 0 && minutes <= 59)){
        return false;
    }
    return true;
}
