# Array
* Time Complexity: O(N)
* Space Complexity: O(N)

## Python 3
```
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        seen = {}
        for i, value in enumerate(numbers):
            remaining = target - numbers[i]
            if remaining in seen:
                return [seen[remaining]+1, i+1]
            seen[value] = i
```

# Two Pointers
* Time Complexity: O(N)
* Space Complexity: O(N)

## Python 3
```
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        for left in range(len(numbers) - 1):
            right = len(numbers) - 1
            while left < right:
                sum = numbers[left] + numbers[right]
                if sum == target:
                    return [left+1, right+1]
                if sum < target:
                    left += 1
                elif sum > target:
                    right -= 1
        
```

## Java
```
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            }
            if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{};
    }
}
```