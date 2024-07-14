# The kth Factor of n

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int kthFactor(int n, int k) {
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                k--;
            }
            if(k == 0){
                return i;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O($\sqrt{N}$)
- Space Complexity: O($\sqrt{N}$)
  - N as n

```java
class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                if(--k == 0){
                    return i;
                }
                list.add(i);
            }
        }
        int mid = (int)Math.sqrt(n);
        if(mid*mid == n){
            k++;
        }
        if(k > list.size()){
            return -1;
        }
        return n/list.get(list.size()-k);
    }
}
```

- Time Complexity: O($\sqrt{N}$)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public int kthFactor(int n, int k) {
        for(int i = 1; i < Math.sqrt(n); i++){
            if(n%i == 0){
                if(--k == 0){
                    return i;
                }
            }
        }
        for(int i = (int)Math.sqrt(n); i >= 1; i--){
            if(n%(n/i) == 0 && --k == 0){
                return n/i;
            }
        }
        return -1;
    }
}
```
