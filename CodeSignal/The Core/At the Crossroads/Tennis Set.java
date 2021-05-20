boolean tennisSet(int score1, int score2) {
    if(score1 >= 5 && score2 >= 5){
        if(score1 == 7 && score2 == 7){
            return false;
        }
        if(score1 >= 7 && score2 >= 7){
            return false;
        }
        if(score1 == 7 || score2 == 7){
            return true;
        }
        return false;
    }
    if(score1 > score2 && score1 == 6){
        return true;
    }
    if(score2 > score1 && score2 == 6){
        return true;
    }
    return false;
}
