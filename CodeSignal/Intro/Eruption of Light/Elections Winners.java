int electionsWinners(int[] votes, int k) {
    
    int max = Integer.MIN_VALUE;
    int people = 0;
    for(int vote: votes){
        if(max < vote){
            max = Math.max(max, vote);
            people = 1;        
        }else if(max == vote){
            people++;
        }
    }
    if(k==0 && people ==1){
        return people;
    }
    int cnt = 0;
    for(int vote: votes){
        if(vote + k > max){
            cnt++;
        }
    }
    return cnt;
}
