int absoluteValuesSumMinimization(int[] a) {
    Arrays.sort(a);
    int min = Integer.MAX_VALUE;
    int index = 0;
    for(int i = a.length - 1; i >= 0; i--){
        int diff = 0;
        for(int j = a.length - 1; j >= 0; j--){
            diff += Math.abs(a[j] - a[i]);
        }        
        if(min >= diff){
            index = a[i];
            min = diff;
        }
    }
    return index;
}
