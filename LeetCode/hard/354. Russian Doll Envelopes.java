class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] == b[0]){
                   return b[1] - a[1];
               }
               return a[0] - b[0];
           } 
        });

        int[] dp = new int[envelopes.length];
        int pos = 0;
        for(int[] envelop: envelopes){
            int i = Arrays.binarySearch(dp, 0, pos, envelop[1]);
            if(i < 0){
                i = Math.abs(i) - 1;
            }
            dp[i] = envelop[1];
            if(i == pos){
                pos++;
            }
        }
        return pos;
    }
}