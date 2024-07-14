# Array Transformation

- Time Complexity: O(cN)
- Space Complexity: O(N)
  - N as length of arr
  - c as cycles

```java
class Solution {
    public List<Integer> transformArray(int[] arr) {
        List<Integer> res = new ArrayList();
        boolean flag = true;
        while(flag){
            flag = false;
            int[] clone = arr.clone();
            for(int i = 1; i + 1 < arr.length; i++){
                int left = clone[i-1],
                    right = clone[i+1];
                if(left > clone[i] && right > clone[i]){
                    arr[i]++;
                    flag = true;
                }else if(left < clone[i] && right < clone[i]){
                    arr[i]--;
                    flag = true;
                }
            }
        }
        res = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return res;
    }
}
```
