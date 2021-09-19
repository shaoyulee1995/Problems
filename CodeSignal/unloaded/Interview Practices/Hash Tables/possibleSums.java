int possibleSums(int[] coins, int[] quantity) {
    HashSet<Integer> sums = new HashSet();
    
    sums.add(0);
    
    for(int i = 0; i < coins.length; i++){
        HashSet<Integer> cur_sum = new HashSet();
        
        for(Integer sum: sums){
            for(int j = 1; j <= quantity[i]; j++){
                cur_sum.add(sum + j * coins[i]);
            }
        }
        sums.addAll(cur_sum);
    }
    return sums.size() - 1;
}
