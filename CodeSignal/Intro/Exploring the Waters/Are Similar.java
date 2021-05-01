boolean areSimilar(int[] a, int[] b) {
    int cnt = 0;
    for(int i = 0; i < a.length; i++){
        if(a[i] != b[i]){
            cnt++;
        }
    }
    
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a,b) && cnt < 3;
}
