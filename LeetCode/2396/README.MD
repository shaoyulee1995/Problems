# Strictly Palindromic Number

- Time Complexity: O(Nlog<sub>w</sub>)
- Space Complexity: O(1)
  - N as n
  - w as length of num

```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i < n-1; i++){
            if(!isPalindromic(toBase(n, i))){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindromic(int[] nums){
        int i = 0,
            j = nums.length-1;
        while(i < j){
            if(nums[i] != nums[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int[] toBase(int n, int base){
        LinkedList<Integer> res = new LinkedList();
        while(n > 0){
            res.add(0, n%base);
            n /= base;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

- Time Complexity: O(Nlog<sub>w</sub>)
- Space Complexity: O(1)
  - N as n
  - w as length of num

```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = n-2; i >= 1; i--){
            if(!isPalindromic(toBase(n, i))){
                return false;
            }
        }
        return true;
    }

    private boolean isPalindromic(int[] nums){
        int i = 0,
            j = nums.length-1;
        while(i < j){
            if(nums[i] != nums[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private int[] toBase(int n, int base){
        LinkedList<Integer> res = new LinkedList();
        while(n > 0){
            res.add(0, n%base);
            n /= base;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}
```
