# Math
* Time Complexity: O(A+B)
* Space Complexity: O(A+B)
	* A as length of aliceSizes
	* B as length of bobSizes
```
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0,
            sumB = 0;
        HashSet<Integer> setB = new HashSet();
        for(int a: aliceSizes){
            sumA += a;
        }
        for(int b: bobSizes){
            setB.add(b);
            sumB += b;
        }
        int delta = (sumB - sumA)/2;
        for(int a: aliceSizes){
            if(setB.contains(a+delta)){
                return new int[]{a, a+delta};
            }
        }
        return null;
    }
}
```