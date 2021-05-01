int[] alternatingSums(int[] a) {
    int[] res = new int[2];
    
    for(int i = 0; i < a.length; i++){
        if(i%2==0){
            res[0] += a[i];
        }else{
            res[1] += a[i];
        }
    }
    return res;
}
