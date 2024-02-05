# Math
* Time Complexity: O(A+B)
* Space Complexity: O(A+B)
	* A as length of aliceSizes
	* B as length of bobSizes
```
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = Arrays.stream(aliceSizes).sum(),
            sumB = Arrays.stream(bobSizes).sum(),
            delta = (sumB-sumA)/2;
        Set<Integer> setB = Arrays.stream(bobSizes).boxed().collect(Collectors.toSet());
        for(int a: aliceSizes){
            if(setB.contains(a+delta)){
                return new int[]{a, a+delta};
            }
        }
        return null;
    }
}
```