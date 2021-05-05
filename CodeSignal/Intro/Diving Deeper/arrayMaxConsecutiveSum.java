int arrayMaxConsecutiveSum(int[] a, int k) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < a.length; i++){
        int sum = 0;
        if(i+k <= a.length){
            for(int j = i; j < k + i; j++){
                sum += a[j];
            }
            max = Math.max(sum, max);
        }
        
    }
    return max;
}