# Linear Search
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of w
```
class Solution {
    
    int[] w_sum;
    public Solution(int[] w) {
        w_sum = new int[w.length];
        for(int i = 1; i < w.length; i++){
            w[i] = w[i] + w[i-1];
            System.out.print(w[i]+", ");
        }
        w_sum = w;
    }
    
    public int pickIndex() {
        int randNum = (int)(w_sum[w_sum.length - 1] * Math.random());
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