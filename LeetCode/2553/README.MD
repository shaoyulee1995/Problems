# Separate the Digits in an Array

- Time Complexity: O(Nn)
- Space Complexity: O(N)
  - N as length of nums
    - n as num

```java
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int num: nums){
          List<Integer> temp = new ArrayList();
          while(num!= 0){
            temp.add(num%10);
            num /= 10;
          }
          for(int i = temp.size()-1; i >= 0; i--){
            res.add(temp.get(i));
          }
        }
        return res.stream().mapToInt(x->x).toArray();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int num: nums){
          sb.append(String.valueOf(num));
        }
        List<Integer> res = new ArrayList();
        for(char c: sb.toString().toCharArray()){
          res.add((c-'0'));
        }
        return res.stream().mapToInt(x->x).toArray();
    }
}
```
