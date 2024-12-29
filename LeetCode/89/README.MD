# Gray Code

- Time Complexity: O(2^N)
- Space Complexity: O(2^N)
  - N as the number of bits

```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList(List.of(0));
        for(int i = 0; i < n; i++){
            int preprocess = 1 << i;
            int size = res.size();
            for(int j = size()-1; j >= 0; j--){
                res.add(res.get(j) + preprocess);
            }
        }
        return res;
    }
}
```