# How Many Apples Can You Put into the Basket

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of weights

```java
class Solution {
    public int maxNumberOfApples(int[] weights) {
        Arrays.sort(weights);
        int res = 0,
            remainWeight = 5000;
        for(int weight: weights){
            remainWeight -= weight;
            if(remainWeight >= 0){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}
```
