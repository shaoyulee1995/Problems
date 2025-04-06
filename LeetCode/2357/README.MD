# Make Array Zero by Subtracting Equal Amounts

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums){
            if(num > 0){
                set.add(num);
            }
        }
        return set.size();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(101)
  - N as length of nums

```java
class Solution {
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        int res = 0;
        for(int num: nums){
            if(num > 0){
                cnt[num]++;
            }
            if(cnt[num] == 1){
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums
  
```cpp
class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        unordered_set<int> set;
        for(auto num: nums){
            if(num == 0){
                continue;
            }
            set.insert(num);
        }
        return set.size();
    }
};
```
