# Count the Digits That Divide a Number

- Time Complexity: O(log<sub>10</sub>N)
- Space Complexity: O(N)
  - N as num

```java
class Solution {
    public int countDigits(int num) {
        int temp = num,
            res = 0;
        Queue<Integer> queue = new LinkedList();
        while(temp != 0){
          queue.offer(temp%10);
          temp /= 10;
        }
        while(!queue.isEmpty()){
          int cur = queue.poll();
          if(num%cur == 0){
            res++;
          }
        }
        return res;
    }
}
```

- Time Complexity: O(log<sub>10</sub>N)
- Space Complexity: O(1)
  - N as num

```java
class Solution {
    public int countDigits(int num) {
        int res = 0,
            temp = num;
        while(temp != 0){
          if(num % (temp%10) == 0){
            res++;
          }
          temp /= 10;
        }
        return res;
    }
}
```
