# Finding 3-Digit Even Numbers

- Time Complexity: O(D)
- Space Complexity: O(D!)
  - D as length of digits

```
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        Arrays.stream(digits).forEach(d -> cnt[d]++);
        List<Integer> res = new ArrayList();
        for(int i = 100; i < 1000; i+=2){
          int[] curCount = new int[10];
          for(int j = i; j > 0; j /= 10){
            curCount[j%10]++;
          }
          if(IntStream.range(0, 10).allMatch(x -> curCount[x] <= cnt[x])){
            res.add(i);
          }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
```
