# Make Array Zero by Subtracting Equal Amounts
# HashSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
## Java
```
class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums){
            if(num == 0){
                continue;
            }
            set.add(num);
        }
        return set.size();
    }
}
```
## C++
```
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