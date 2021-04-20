int makeArrayConsecutive2(int[] statues) {
    Arrays.sort(statues);
    int cnt = 0;
    for(int i = 0; i < statues.length - 1; i++){
        int diff = statues[i+1] - statues[i];
        if(diff == 1){
            continue;
        }
        
        cnt += statues[i+1] - statues[i] - 1;
    }
    return cnt;
}
