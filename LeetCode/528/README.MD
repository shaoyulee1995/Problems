# Random Pick with Weight
# Linear Search
* Time Complexity: O(W)
* Space Complexity: O(W)
	* W as length of w
```
class Solution {

    int[] w_sum;
    public Solution(int[] w) {
        w_sum = new int[w.length];
        for(int i = 1; i < w.length; i++){
            w[i] = w[i] + w[i-1];
        }
        w_sum = w;
    }
    
    public int pickIndex() {
        Random r = new Random();
        int randNum = (int)(r.nextInt(w_sum[w_sum.length - 1]));
        for(int i = 0; i < w_sum.length; i++){
            if(randNum < w_sum[i]){
                return i;
            }
        }
        return -1;
    }
}
```
```
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```