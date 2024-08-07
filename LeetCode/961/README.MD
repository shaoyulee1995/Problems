# N-Repeated Element in Size 2 N Array

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                return num;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(10000)

```java
class Solution {
    public int repeatedNTimes(int[] A) {
        int[] cnt = new int[10000];

        for(int a: A){
            cnt[a]++;
            if(cnt[a] == 2){
                return a;
            }
        }
        return 0;
    }
}
```
