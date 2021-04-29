class Solution {
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        
        int cnt = 0;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(!notPrime[i]){
                for(int j = 2; j*i < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}