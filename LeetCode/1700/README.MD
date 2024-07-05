# Number of Students Unable to Eat Lunch

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of students

```
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counter = new int[]{0, 0};
        for(int student: students){
            counter[student]++;
        }
        int i = 0;
        for(; i < sandwiches.length && counter[sandwiches[i]] > 0; i++){
            counter[sandwiches[i]]--;
        }
        return students.length - i;
    }
}
```
